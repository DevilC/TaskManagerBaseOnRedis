package taskPackage;

import com.sun.istack.internal.NotNull;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import taskLoadExceptionPackage.TaskDefineTagWrongException;
import taskLoadExceptionPackage.TaskNotFoundException;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskFactory {
    private static final String TASKNAME_TAG = "taskName";
    private static final String CLASSPATH_TAG = "classPath";
    private static final String CLASSLIST_TAG = "classList";

    private static final String[] necessaryAttributes = {"taskName", "businessType", "level"};

    private static TaskFactory instance = new TaskFactory();


    /**
     * 存储从文件加载的任务名与Class对象列表的映射
     */
    private HashMap<String, Task> taskNameTaskMap = new HashMap<String, Task>();

    TaskFactory() {
        loadTaskDefine();
    }

    /**
     * 加载TaskDefine.xml文件
     */
    public void loadTaskDefine(){
        File file = new File(TaskFactory.class.getResource("TaskDefine.xml").getPath());
        try(InputStream is = new FileInputStream(file)){
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(is);
            Element root = document.getRootElement();
            List<Element> tasks = root.getChildren();
            for(Element task: tasks){
                List<Element> items = task.getChildren();
                String taskName = "";
                List<Class> classList = new ArrayList<Class>();
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从XML Element Task 对象中提取task对象
     * @param taskElement XML Element Task对象
     * @return Task对象
     * @throws TaskDefineTagWrongException task标签定义错误exception
     * @throws DataConversionException task标签属性类型转换异常
     */
    public Task getTaskExtractorFromXMLElement(Element taskElement) throws TaskDefineTagWrongException, DataConversionException {
        List<Element> items = taskElement.getChildren();
        Task task = extractorAttributeFromTaskElement(taskElement);
        List<Class> classList = new ArrayList<Class>();

        for (Element item : items) {
            try {
                if (item.getName().equals(CLASSLIST_TAG)) {
                    List<Element> classPathElementList = item.getChildren();
                    for (Element classPath : classPathElementList) {
                        if (classPath.getName().equals(CLASSPATH_TAG)) {
                            classList.add(Class.forName(classPath.getValue()));
                        }
                    }
                } else {
                    throw new TaskDefineTagWrongException(item.getName());
                }
            }
            catch (ClassNotFoundException e){
                throw new TaskDefineTagWrongException(item.toString());
            }
        }

        TaskSectionExtractor extractor = new TaskSectionExtractor(task, classList);
        return extractor.doExtractor();
    }

    /**
     * 把XML Elemnt对象属性转换为Task对象
     * @param taskElement XML Elemnt对象
     * @return Task对象
     * @throws TaskDefineTagWrongException task标签定义错误exception
     * @throws DataConversionException task标签属性类型转换异常
     */
    public Task extractorAttributeFromTaskElement(Element taskElement) throws TaskDefineTagWrongException, DataConversionException {
        List<Attribute> attributes = taskElement.getAttributes();
        for(String necessaryAttr: necessaryAttributes){
            boolean isExist = false;
            for(Attribute attr: attributes){
                if(attr.getName().equals(necessaryAttr)){
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                throw new TaskDefineTagWrongException(necessaryAttr);
            }
        }
        Task task = new Task();
        task.setTaskName(taskElement.getAttribute("taskName").getValue());
        task.setBusinessType(taskElement.getAttributeValue("businessType"));
        task.setLevel(taskElement.getAttribute("level").getIntValue());
        if(taskElement.getAttribute("exclusiveType") != null){
            task.setExclusive(true);
            task.setExclusiveType(ExclusiveType.getExclusiveType(taskElement.getAttribute("exclusiveType").getValue()));
        }
        if(taskElement.getAttribute("canInterrupt") != null){
            task.setCanInterrupt(taskElement.getAttribute("canInterrupt").getBooleanValue());
        }
        if(taskElement.getAttribute("timeout") != null){
            task.setTimeout(taskElement.getAttribute("timeout").getIntValue());
        }
        return task;
    }

    /**
     * 获取Task Factory实例
     * @return TaskFactory实例
     */
    public static TaskFactory getInstance(){
        return instance;
    }

    /**
     * 通过taskName获取task
     * @param taskName
     * @return Task对象
     */
    public Task getTaskByName(String taskName) throws TaskNotFoundException {
        if(!this.taskNameTaskMap.containsKey(taskName)){
            throw new TaskNotFoundException(taskName);
        } else{
            return taskNameTaskMap.get(taskName);
        }
    }
}
