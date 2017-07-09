


import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class test extends Application {

	public ObservableList<Student> data =  FXCollections.observableArrayList(
			new Student("1234","Dohn","Zoo",1),
			new Student("1235","Bane","Yonder",2),
			new Student("1236","Comchai","Xaidee",3),
			new Student("1237","Aome","Wtudent",4)
			);

	public static void main(String args[]){

		
	
		//Fruit.sortByQuantity(fruits);

		
		/*
		Student.sort(students,Student.IDComparator,true);
		Student.sort(students,Student.NameComparator,true);
		Student.sort(students,Student.LastNameComparator,true);
		Student.sort(students,Student.GPAComparator,true);
		
		
		for(Student temp: students){
			System.out.println(temp.getID()  +  " " + temp.getName() + 
					
			 " " +temp.getLastName()+ " " + temp.getGPA());
			}
	}*/
			launch(args);
	}
	
		

		@Override
		public void start(Stage primaryStage) throws Exception {
			
			ArrayList<Student> students = new ArrayList<Student>();
			Student s;
			s = new Student("1234","Dohn","Zoo",1);
			students.add(s);
			s = new Student("1235","Bane","Yonder",2);
			students.add(s);
			s= new Student("1236","Comchai","Xaidee",3);
			students.add(s);
			s= new Student("1237","Aome","Wtudent",4);
			students.add(s);
			
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid,333,400);
			primaryStage.setTitle("Sorting Student");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Label ID = new Label("ID");
			Label Name = new Label("Name");
			Label LastName = new Label("LastName");
			Label GPA = new Label("GPA");
			Label Ascending = new Label("Ascending");
			Label Descending = new Label("Descending");
			RadioButton rAsc = new RadioButton();
			RadioButton rDsc = new RadioButton();
			RadioButton rID  = new RadioButton();
			RadioButton rName  = new RadioButton();
			RadioButton rLastName  = new RadioButton();
			RadioButton rGPA  = new RadioButton();
			Button    sort = new Button("Sort");
			Button	  add  = new Button("Add");
			Button    delete = new Button ("Delete");
			Text title = new Text("Sorting Student");
			
			TextField tName = new TextField();
			TextField tLastName = new TextField();
			TextField tID = new TextField();
			TextField tGPA = new TextField();
			
			
			
			tName.setPromptText("Enter a new Name");
			tLastName.setPromptText("Enter a new Last Name");
			tID.setPromptText("Enter a new ID");
			tGPA.setPromptText("Enter a new GPA");
			
			
			grid.add(title, 0, 0,2,1);
			
			grid.add(rID,0,22);
			grid.add(ID,1,22);
	
			grid.add(rName,0,24);
			grid.add(Name,1,24);
			
			grid.add(rLastName,0,26);
			grid.add(LastName,1,26);
			
			grid.add(rGPA,0,28);
			grid.add(GPA,1,28);
			
			grid.add(rAsc,2,22);
			grid.add(Ascending,3,22);
			
			grid.add(rDsc,2,24);
			grid.add(Descending,3,24);
		
			grid.add(tID,4,22,1,1);
			grid.add(tName,4,24,1,1);
			grid.add(tLastName,4,26,1,1);
			grid.add(tGPA,4,28,1,1);
	
			grid.add(sort, 2, 26,1,1);
			grid.add(add,2,28,1,
					1);
			grid.add(delete,3, 28,1,1);
		
			ToggleGroup group = new ToggleGroup();
			rGPA.setToggleGroup(group);
			rID.setToggleGroup(group);
			rLastName.setToggleGroup(group);
			rName.setToggleGroup(group);
			
			ToggleGroup group2 = new ToggleGroup();
			rAsc.setToggleGroup(group2);
			rDsc.setToggleGroup(group2);
			
			TableView<Student> table = new TableView<Student>();
			table.setEditable(true);
			TableColumn<Student, String> cID = new TableColumn<Student, String>("ID");
			TableColumn<Student, String> cName = new TableColumn<Student, String>("Name");
			TableColumn<Student, String> cLastName = new TableColumn<Student, String>("Last Name");
			TableColumn<Student,String> cGPA = new TableColumn<Student, String>("GPA");
			table.getColumns().addAll(cID,cName,cLastName,cGPA);
			table.setMaxSize(333, 300);
			cGPA.setCellValueFactory(new PropertyValueFactory
					<Student,String>("GPA"));;
			cName.setCellValueFactory(new PropertyValueFactory
							<Student,String>("Name"));;
			cLastName.setCellValueFactory(new PropertyValueFactory
									<Student,String>("LastName"));;
			cID.setCellValueFactory(new PropertyValueFactory
											<Student,String>("ID"));;
			table.setItems(data);								
											
											
			grid.add(table, 0,1,20,20);
			
			sort.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				@Override public void handle(MouseEvent e){
					if(group.getSelectedToggle() != null){
						if(group2.getSelectedToggle() != null){
							data.clear();
							if(rID.isSelected()){
								if(rAsc.isSelected())
								{Student.sort(students,Student.IDComparator,true);}
								else
								{Student.sort(students,Student.IDComparator,false);}
							}
							else if(rName.isSelected()){
								if(rAsc.isSelected())
								{Student.sort(students,Student.NameComparator,true);}
								else
								{Student.sort(students,Student.NameComparator,false);}		
							}
							else if(rLastName.isSelected()){
								if(rAsc.isSelected())
								{Student.sort(students,Student.LastNameComparator,true);}
								else
								{Student.sort(students,Student.LastNameComparator,false);}
							}
							else{
								if(rAsc.isSelected())
								{Student.sort(students,Student.GPAComparator,true);}
								else
								{Student.sort(students,Student.GPAComparator,false);}
							}
							
							
							for(int i =0;i<students.size();i++){
								System.out.println(students.get(i).getID()  +  " " + students.get(i).getName() + 
										
								 " " +students.get(i).getLastName()+ " " + students.get(i).getGPA());
								
								
								data.add(new Student(students.get(i).getID(),students.get(i).getName(),students.get(i).getLastName(),students.get(i).getGPA()));
							}
							
							table.setItems(data);
							
							
							
						
						}
					}
				}
				
			});
			
			add.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
				@Override public void handle(MouseEvent e){
					if(!(tName.getText().isEmpty() || tLastName.getText().isEmpty() ||
							tID.getText().isEmpty() || tGPA.getText().isEmpty())	){
						data.add(new Student(tID.getText(),tName.getText(),tLastName.getText(),Double.parseDouble(tGPA.getText())));
						Student snew;
						snew = new Student(tID.getText(),tName.getText(),tLastName.getText(),Double.valueOf(tGPA.getText()));
						students.add(snew);
					}
				}
			});
			
			delete.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
				@Override public void handle(MouseEvent e){
					if(table.getSelectionModel().getSelectedIndex() != -1){
					students.remove(table.getSelectionModel().getSelectedIndex());
					data.clear();
					for(int i =0;i<students.size();i++){
						data.add(new Student(students.get(i).getID(),students.get(i).getName(),students.get(i).getLastName(),students.get(i).getGPA()));
					}
					table.setItems(data);
					}
					
				}
			});
			
			
		}
		
		
}