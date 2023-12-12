package controller;

import model.StudentModel;
import view.StudentView;

public class StudentCtrl {
	private StudentModel model;
	private StudentView view;
	public StudentCtrl() {
		this.model=new StudentModel();
		this.view=new StudentView();
	}
	
	
	public void startApp() {
		int PK=1002;
		while(true) {
			view.printMenu();
			int action=view.inputAction();
			if(action==0) {
				break;
			}
			else if(action==1) {
				String name=view.inputName();
				int score=view.inputScore();
				boolean flag=model.insert(PK++, name, score);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==2) {
			
			}
			else if(action==3) {
				
			}
			else if(action==4) {
			}
				
		}
	}
}
