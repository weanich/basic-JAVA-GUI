import java.util.ArrayList;
import java.util.Comparator;

public class Student {
	private String Name;
	private String LastName;
	private	double  GPA;
	private String ID;
	public Student(String ID, String Name, String LastName,double GPA){
		super();
		this.ID 		= ID;
		this.Name 		= Name;
		this.LastName 	= LastName;
		this.GPA		= GPA;
	}
	
	public String getName() {return Name;}
	public void setName(String Name) { this.Name = Name;}
	public String getLastName() {return LastName;}
	public void setLastName(String LastName) { this.LastName = LastName;}
	public String getID() {return ID;}
	public void setID(String ID) { this.ID = ID;}
	public double getGPA() {return GPA;}
	public void setGPA(double GPA) { this.GPA = GPA;}
	

	
	
	
	public static Comparator<Student> NameComparator = new Comparator<Student>(){
		public int compare(Student student1,Student student2){
			String	name1 = student1.getName().toUpperCase();
			String  name2 = student2.getName().toUpperCase();
			return name1.compareTo(name2);
		}
	};
	
	public static Comparator<Student> LastNameComparator = new Comparator<Student>(){
		public int compare(Student student1,Student student2){
			String	lastName1 = student1.getLastName().toUpperCase();
			String  lastName2 = student2.getLastName().toUpperCase();
			return lastName1.compareTo(lastName2);
		}
	};
	
	public static Comparator<Student> IDComparator = new Comparator<Student>(){
		public int compare(Student student1,Student student2){
			String	ID1 = student1.getID().toUpperCase();
			String  ID2 = student2.getID().toUpperCase();
			return ID1.compareTo(ID2);
		}
	};
	
	public static Comparator<Student> GPAComparator = new Comparator<Student>(){
		public int compare(Student student1,Student student2){
			int i;
			double  GPA1 = student1.getGPA();
			double  GPA2 = student2.getGPA();
			if(GPA1-GPA2 > 0){
				i = 1;
			}
			else if(GPA1-GPA2 == 0){
				i = 0;
			}
			else{
				i = -1;
			}
			return i;
		}
	};
	
	
	public static void sort(ArrayList<Student> f, Comparator<Student> c,boolean asc){
		int i, j;
		Student tmp;
			for (i=0; i<f.size()-1;i++){
				for(j=i+1;j<f.size();j++)
					if((c.compare(f.get(i),f.get(j)) >0 && asc==true) ||(c.compare(f.get(i),f.get(j)) <0 && asc==false))
						{
							tmp = f.get(i); 
							f.set(i,f.get(j)); 
							f.set(j,tmp); 
						}
				}
	}

}
