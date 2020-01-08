package taskPackage;

import JobPackage.Job;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import sun.reflect.Reflection;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskFactory {
    private static final String TASKNAME_TAG = "taskName";
    private static final String CLASSPATH_TAG = "classPath";
    private static final String CLASSLIST_TAG = "classList";

    private static TaskFactory instance = new TaskFactory();


    /**
     * 存储从文件加载的任务名与Class对象列表的映射
     */
    private HashMap<String, ArrayList<Class>> taskNameClassMap = new HashMap<String, ArrayList<Class>>();

    TaskFactory() {
        File file = new File(TaskFactory.class.getResource("TaskDefine.xml").getPath());
        try(InputStream is = new FileInputStream(file)){
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(is);
            Element root = document.getRootElement();
            List<Element> tasks = root.getChildren();
            for(Element task: tasks){
                List<Element> items = task.getChildren();
                String taskName = "";
                List<Class> classList = new ArrayList<Class>(items.size() - 1);
                for(Element item: items){
                    if(item.getName().equals(TASKNAME_TAG)){
                        taskName = item.getValue();
                    } else if(item.getName().equals(CLASSLIST_TAG)){
                        List<Element> classes = item.getChildren();
                        for(Element classPath: classes){
                            classList.add(Class.forName(classPath.getValue()));
                        }
                    } else{
                        throw new TaskDefineTagWrongException("TaskDefine tag wrong!");
                    }
                }
            }
        } catch (IOException e){

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (TaskDefineTagWrongException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取Task Factory实例
     * @return TaskFactory实例
     */
    public static TaskFactory getInstance(){
        return instance;
    }

    public Task getTaskByName(String taskName){
        return new Task();
    }

}
