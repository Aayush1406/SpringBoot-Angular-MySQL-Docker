import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
 
  private baseUrl : string = 'http://localhost:9898/student'
  constructor(private http:HttpClient) { }

  getAllStudents():Observable<Student[]>{
    console.log('making call to rest api to get all students info')

    return this.http.get<Student[]>(`${this.baseUrl}/all`);
    
  }

  
  deleteStudent(id:number){
    return this.http.delete(`${this.baseUrl}/remove/${id}`, {responseType:'text'});
  }

  createStudent(std:Student){
    console.log("create service called !")
    console.log(std);
    return this.http.post(`http://localhost:9898/student/create`,std,{responseType:'text'});
    
  }

  findStudent(id:number):Observable<Student>{
    console.log("find student service called !")
    return this.http.get<Student>(`${this.baseUrl}/one/${id}`);
  }

  updateStudent(student: Student) {
   
    console.log("Studnt ID = "+student.stdId)
    return this.http.put(`${this.baseUrl}/update`,student,{responseType:'text'})
  }

}
