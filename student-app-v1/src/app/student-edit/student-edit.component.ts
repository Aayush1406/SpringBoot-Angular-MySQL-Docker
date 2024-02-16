import { Component } from '@angular/core';
import { Student } from '../student';
import { ActivatedRoute } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrl: './student-edit.component.css'
})
export class StudentEditComponent {

  id:number=0;
  student:Student = new Student(0,'',0,'',0,0); 
  msg:string="";
  constructor(private route: ActivatedRoute, private service:StudentService){
    
  }

  ngOnInit(){
    this.getStudent();
     }

  getStudent(){
  
  
  this.id = this.route.snapshot.params['id'];
  this.service.findStudent(this.id).subscribe(
    data=>{this.student=data;
      console.log("get student id-"+this.student.stdId);
    }
 
  )
  }

  onSubmit(student:Student) {
  student.stdId=this.route.snapshot.params['id'];
    console.log("On Submit id-"+student.stdId);
   this.service.updateStudent(student).subscribe(
    data=>{
      this.msg=data;      
    }
   );
  }
}
