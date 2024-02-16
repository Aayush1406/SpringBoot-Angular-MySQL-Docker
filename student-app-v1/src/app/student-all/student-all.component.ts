import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { error } from 'console';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-all',
  templateUrl: './student-all.component.html',
  styleUrl: './student-all.component.css'
})
export class StudentAllComponent implements OnInit{

  students:Student[] = [];
  message:string="";
  constructor(private service:StudentService, private router: Router){} //Injecting the service first.

  ngOnInit(): void {
   
    this.getAllStudents();
  }
  

  getAllStudents(){
    this.service.getAllStudents().subscribe(
      data=>{this.students=data}, //on successfully retrieving the data from subscribe it will store "data" in students array.
    
      error=>{this.students=[];
      console.log(error)
    } 
      );
  }

  deleteStudent(id:number){
    this.service.deleteStudent(id).subscribe(
      data=>{this.message=data, this.getAllStudents()},
      error=>{console.log(error)}
  
    )
    }

  editStudent(id:number){
    this.router.navigate(['edit/',id]);

  }
}
