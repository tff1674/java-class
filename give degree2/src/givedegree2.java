//编写一个程序，通过面向接口编程思想，实现学位颁发功能。
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Exception;
class Constants {
    public final static String UNDERGRADUATE = "大学本科生";
    public final static String MASTER = "硕士研究生";
    public final static String ISSUE_UNDERGRADUATE_DEGREE="颁发学士学位";
    public final static String ISSUE_MASTER_DEGREE="颁发硕士学位";
    public final static String UNSATISFACTORY_ISSUE_UNDERGRADUATE_DEGREE="不满足颁发学士学位要求";
    public final static String UNSATISFACTORY_ISSUE_MASTER_DEGREE="不满足颁发硕士学位要求";
}
abstract class Student{
    String name;
    char gender;
    Date birthDay;
    String school;
    String stuId;
    String category;
    double[] score;
    boolean status;
    void setName(String name){
        this.name=name;
    }
    void setGender(char gender){
        this.gender=gender;
    }
    void setBirthDay(Date birthDay){
        this.birthDay=birthDay;
    }
    void setSchool(String school){
        this.school=school;
    }
    void setStuId(String stuId){
        this.stuId=stuId;
    }
    void setCategory(String category){
        this.category=category;
    }
    void setScore(double[] score){
        this.score=score;
    }
    void setStatus(boolean status){
        this.status=status;
    }
    String getName(){return name;}
    char getGender(){return gender;}
    Date getBirthDay(){return birthDay;}
    String getSchool(){return school;}
    String getStuId(){return stuId;}
    String getCategory(){return category;}
    double []getScore(){return score;}
    boolean getStatus(){return status;}
    public abstract String getDegree();
}
interface Manageable{
    public abstract double computeAverage() throws Exception;
    public abstract boolean getPass();
    public abstract void printInfo();
}
class  UndergraduateException extends Exception{
    String message;
    public  UndergraduateException(double s){
        message="该大学生的某门成绩是"+s+"不在0-100范围内，不符合要求。";
    }
    public String warnMess(){
        return message;
    }
}
class  MasterException extends Exception{
    String message;
    public  MasterException(char t){
        message="该硕士的某个等级是"+t+"不在A-E范围内，不符合要求。";
    }
    public String warnMess(){
        return message;
    }
}
class Undergraduate extends Student implements Manageable{
    double aver;
    public double computeAverage() throws UndergraduateException{
        double[] s;
        s=getScore();
        double sum=0;
        for(int i=0;i<s.length;i++){
            if(s[i]>100||s[i]<0){
                throw new UndergraduateException(s[i]);
            }
            sum=sum+i;
        }
        aver=sum/s.length;
        return aver;
    }

    @Override
    public boolean getPass(){
        try{
           computeAverage();}
        catch(UndergraduateException e){
            System.out.println("计算大学生平均分过程时出现如下问题：");
            System.out.println(e.warnMess());
        }
        if(aver>=60){
            setStatus(true);
            return true;
        }
        else
            setStatus(false);
            return false;
    }
    public String getDegree(){
        boolean k=getStatus();
        if(k==true){
            return Constants.ISSUE_UNDERGRADUATE_DEGREE;}
        else
            return Constants.UNSATISFACTORY_ISSUE_UNDERGRADUATE_DEGREE;
        }
    public void printInfo(){
        String name;      //学生姓名
        char gender;      //学生性别
        Date birthDay;    //学生出生日期
        String school;    //学校
        String stuId;     //学号
        String category;   //学生类别
        double[] s;
        boolean p;
        name=getName();
        gender=getGender();
        birthDay=getBirthDay();
        school=getSchool();
        stuId=getStuId();
        category=getCategory();
        s=getScore();
        p=getStatus();
        System.out.println("该生的姓名为："+name+'\n'+"性别为："+gender+"\n"+"出生日期为："+birthDay+'\n'+
                "学校为："+school+'\n'+"学号为："+stuId+'\n'+"学生类别为："+category+'\n'+
                "各门成绩为："+java.util.Arrays.toString(s)+'\n'+"学位颁发状态为："+p+'\n');
    }
}
class Master extends Student implements Manageable{
    double aver;
    char thesisLevel;
    void setThesisLevel(char t){
        thesisLevel=t;
    }
    char getThesisLevel(){return thesisLevel;}
    public double computeAverage() throws Exception{
        double [] score ;
        score=getScore();
        int l = score.length;
        double mutiple=1;
        if(thesisLevel>'E'||thesisLevel<'A')
            throw new MasterException(thesisLevel);
        for (int i = 0; i < l; i++) {
            if(score[i]>100||score[i]<0)
                throw new UndergraduateException(score[i]);
            mutiple *= score[i];
        }
        aver=Math.pow(mutiple,1.0/l);

        return aver;
    }

    @Override
    public boolean getPass() {
        double a;
        try {
            a = computeAverage();
            if (a >= 80 && thesisLevel == 'A' || thesisLevel == 'B' || thesisLevel == 'C') {
                setStatus(true);
                return true;
            } else {
                return false;
            }
        } catch(UndergraduateException e) {
            System.out.println("计算大学生平均分过程时出现如下问题：");
            System.out.println(e.warnMess());
        } catch(MasterException e1) {
            System.out.println("计算大学生平均分过程时出现如下问题：");
            System.out.println(e1.warnMess());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   public String getDegree(){
        boolean k=getStatus();
       if(k==true){
           return Constants.ISSUE_MASTER_DEGREE;}
       else
           return Constants.UNSATISFACTORY_ISSUE_MASTER_DEGREE;
   }
   public void printInfo(){
       String name;      //学生姓名
       char gender;      //学生性别
       Date birthDay;    //学生出生日期
       String school;    //学校
       String stuId;     //学号
       String category;   //学生类别
       double[] score;     //成绩
       char thesislevel;
       boolean p;
       name=getName();
       gender=getGender();
       birthDay=getBirthDay();
       school=getSchool();
       stuId=getStuId();
       category=getCategory();
       score=getScore();
       thesislevel=getThesisLevel();
       p=getStatus();
       System.out.println("该生的姓名为："+name+'\n'+"性别为："+gender+"\n"+"出生日期为："+birthDay+'\n'+
               "学校为："+school+'\n'+"学号为："+stuId+'\n'+"学生类别为："+category+'\n'+
               "各门成绩为："+java.util.Arrays.toString(score)+'\n'+"论文等级为："+thesislevel+'\n'+"学位颁发状态为："+p+'\n');
   }
}
class StudentDegree{
    public void issueDegree(Manageable manage)throws Exception{
        manage.computeAverage();
        manage.printInfo();
    }

}
class StudentApplication{
    public static void main(String[] args) throws Exception {
      try {
          Undergraduate undergraduate = new Undergraduate();
          undergraduate.setName("王小二");
          undergraduate.setGender('男');
          undergraduate.setBirthDay(new SimpleDateFormat("yyyy-MM-dd").parse("1998-6-1"));
          undergraduate.setSchool("上海大学");
          undergraduate.setStuId("11128981");
          undergraduate.setCategory("大学本科生");
          double[] a = {89.5, 82, 87, 73};
          undergraduate.setScore(a);
          undergraduate.setStatus(false);
          Master master = new Master();
          master.setName("李燕");
          master.setGender('女');
          master.setBirthDay(new SimpleDateFormat("yyyy-MM-dd").parse("1992-6-12"));
          master.setSchool("上海大学");
          master.setStuId("10306");
          master.setCategory("硕士研究生");
          double[] b = {70, 52.5, 95, 88, 89, 91};
          master.setScore(b);
          master.setThesisLevel('B');
          master.setStatus(false);
          StudentDegree studentDegree = new StudentDegree();
          studentDegree.issueDegree(undergraduate);
          studentDegree.issueDegree(master);
      }
      catch(UndergraduateException e) {
          System.out.println("计算大学生平均分过程时出现如下问题：");
          System.out.println(e.warnMess());
      }
      catch(MasterException e1) {
          System.out.println("计算大学生平均分过程时出现如下问题：");
          System.out.println(e1.warnMess());
      }
    }
}