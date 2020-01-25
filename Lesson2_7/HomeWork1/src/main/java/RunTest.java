import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;


class MethodComparator implements Comparator<Method> {

    public int compare(Method m1, Method m2) {
        return (m1.getAnnotation(Test.class).priorityLevel() < m2.getAnnotation(Test.class).priorityLevel())?-1:1;
    }
}

public class RunTest {

    public static void start() throws InvocationTargetException, IllegalAccessException {
        Class annoTest = AnnoTest.class;
        Method[] methods = annoTest.getDeclaredMethods();
        AnnoTest anno = new AnnoTest();

        Method before = null;
        Method after = null;

       SortedSet<Method> methodSet = new TreeSet<Method>( new MethodComparator());

        for (Method m:methods){
            if (m.isAnnotationPresent(BeforeSuite.class))
            {
                if (before == null) before = m;
                 else throw new RuntimeException("double BeforeSuite");
            } else

            if (m.isAnnotationPresent(AfterSuite.class))
            {
                if (after == null) after= m;
                else throw new RuntimeException("double AfterSuite");
            } else

            if (m.isAnnotationPresent(Test.class))
            {
                methodSet.add(m);
            }
        }

     if (before != null) {
         try {
             before.invoke(anno);
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         } catch (InvocationTargetException e) {
             e.printStackTrace();
         }
     }

     for (Method m : methodSet) {
            m.invoke(anno);
        }

     if (after != null) {
         after.invoke(anno);
     }


    }
}
