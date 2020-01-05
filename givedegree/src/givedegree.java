import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//创建一个类 Constants,里面定义各类在此Java 程序中使用到的常量，分别如下：
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

    void setName(String n){
        name=n;
    }
    String getName(){return name;}
    void setGender(char g){
        gender=g;
    }
    char getGender(){return gender;}
    void setBirthDay(Date b){
        birthDay=b;
    }
    Date getBirthDay(){return birthDay;}
    void setSchool(String s){
        school=s;
    }
    String getSchool(){return school;}
    void setStuId(String id){
        stuId=id;
    }
    String getStuId(){return stuId;}
    void setCategory(String c){
        category=c;
    }
    String getCategory(){return category;}

    void setScore(double[] score) {
        this.score = score;
    }
    double[] getScore(){return score;}

    public void setStatus(boolean status) {
        this.status = status;
    }
    boolean getStatus(){return status;}
    public abstract boolean getPass();//判断是否满足学位颁发条件
    public abstract double computeAverage();//计算学生课程平均值
    public abstract String getDegree();//判定是否发学位
}
class Undergraduate extends Student{
     double aver;//大学生课程成绩平均值

    @Override
    public boolean getPass() {//判断是否满足学位颁发条件
        aver=computeAverage();
         if(aver>=60){
             boolean k=true;
             setStatus(k);
             return true;
         }
         else{
             return false;
         }
    }

    @Override
    public double computeAverage() {
        double [] score;
        score=getScore();
        int l=score.length;
        double sum=0;
        for(int i=0;i<l;i++){
            sum+=score[i];
        }
        aver=sum/l;
        return aver;
    }

    @Override
    public String getDegree() {//判断是否发学位
        boolean k=getStatus();
        if(k==true) {
            return Constants.ISSUE_UNDERGRADUATE_DEGREE;}
		else
		    return Constants.UNSATISFACTORY_ISSUE_UNDERGRADUATE_DEGREE;

        }
}
class Master extends Student {
    double aver;
    char thesisLevel;
    void setThesisLevel(char t){
        thesisLevel=t;
    }
    @Override
    public double computeAverage() {
        double [] score ;
        score=getScore();
        int l = score.length;
        double mutiple=1;
        for (int i = 0; i < l; i++) {
            mutiple *= score[i];
        }
//        aver = Math.sqrt(mutiple);
        aver=Math.pow(mutiple,1.0/l);

        return aver;
    }

    @Override
    public boolean getPass() {
        aver=computeAverage();
        if (aver >= 80 && (thesisLevel == 'C' || thesisLevel == 'B' || thesisLevel == 'A')) {
            boolean k=true;
            setStatus(k);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDegree() {
        boolean k=getStatus();
        if(k==true){
            return Constants.ISSUE_MASTER_DEGREE;}
		else
            return Constants.UNSATISFACTORY_ISSUE_MASTER_DEGREE;

    }
}
class StudentDegree{
    public void printStudentInfo(Student student){

        String name;      //学生姓名
        char gender;      //学生性别
        Date birthDay;    //学生出生日期
        String school;    //学校
        String stuId;     //学号
        String category;   //学生类别
        double avg;     //平均成绩
//        boolean p;
        name=student.getName();
        gender=student.getGender();
        birthDay=student.getBirthDay();
        school=student.getSchool();
        stuId=student.getStuId();
        category=student.getCategory();
        avg=student.computeAverage();
//        p=student.getPass();
        System.out.println("该生的姓名为："+name+'\n'+"性别为："+gender+"\n"+"出生日期为："+birthDay+'\n'+
                "学校为："+school+'\n'+"学号为："+stuId+'\n'+"学生类别为："+category+'\n'+
                "平均分为："+avg+'\n');
    }
    public void issueDegree(Student student){
        String s;
        student.getPass();
        student.computeAverage();
        s=student.getDegree();
        System.out.println("学生学位授予情况: "+s);
    }
}
class StudentApplication {
    public static void main(String[] args) throws ParseException {
        Student student;
        Undergraduate undergraduate = new Undergraduate();
//        student=undergraduate;
        undergraduate.setName("王小二");
        undergraduate.setGender('男');
        undergraduate.setBirthDay(new SimpleDateFormat("yyyy-MM-dd").parse("1995-6-1"));
        undergraduate.setSchool("上海大学");
        undergraduate.setStuId("11128981");
        undergraduate.setCategory("大学本科生");
        double[] a={89.5,82,87,73};
        undergraduate.setScore(a);
        undergraduate.setStatus(false);
        Master master=new Master();
        master.setName("李燕");
        master.setGender('女');
        master.setBirthDay(new SimpleDateFormat("yyyy-MM-dd").parse("1991-6-12"));
        master.setSchool("上海大学");
        master.setStuId("10306");
        master.setCategory("硕士研究生");
        double[] b={70,52.5,95,88,89,91};
        master.setScore(b);
        master.thesisLevel='B';
        master.setStatus(false);
        StudentDegree studentDegree=new StudentDegree();
        studentDegree.issueDegree(undergraduate);
        studentDegree.issueDegree(master);
        //使用student作为undergraduate的上转型对象,测试studentDegree 使用 student 上转型对象，输出学生信息和学位授予情况。
        student=undergraduate;
        studentDegree.printStudentInfo(student);
        studentDegree.issueDegree(student);

        //使用 student作为master的上转型对象，测试studentDegree 使用 student 上转型对象，输出学生信息和学位授予情况。
        student=master;
        studentDegree.printStudentInfo(student);
        studentDegree.issueDegree(student);
    }
}
