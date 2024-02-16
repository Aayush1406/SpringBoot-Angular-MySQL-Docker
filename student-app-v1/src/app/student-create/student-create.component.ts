import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrl: './student-create.component.css'
})
export class StudentCreateComponent {

  students:Student[] = [];
  student:Student = new Student(0,'',0,'',0,0);
  msg:string='';

  constructor(private service:StudentService){} //Injecting the service first.


onSubmit(studentData:Student) 
{
     // Map form data to the Student model here

     this.student.stdName = studentData.stdName;
     this.student.stdFee = studentData.stdFee;
     this.student.stdCourse = studentData.stdCourse;
 
     // Handle the mapped student object (e.g., send to service, log, etc.)
     console.log('Registered student:', this.student);

     this.createStudent(this.student);

  }

createStudent(student:Student){
  this.service.createStudent(this.student).subscribe(
    data => {
      this.msg=data;
    },
    error => {
      console.error('Error while creating student:', error);
    }
  );

  // this.getAllStudents();
}  

// getAllStudents(){
//   this.service.getAllStudents().subscribe(
//     data=>{this.students=data}, //on successfully retrieving the data from subscribe it will store "data" in students array.
  
//     error=>{this.students=[];
//     console.log(error)
//   } 
//     );
// }

}
