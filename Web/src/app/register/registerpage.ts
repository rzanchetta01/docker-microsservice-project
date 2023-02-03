
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormBuilder, FormControl, Validators } from "@angular/forms";

@Component({
    selector: 'app-root',
    templateUrl: './registerpage.html',
    styleUrls: ['./registerpage.css']
})
export class RegisterPage {
    title = "tmp-app";

    readonly apiUrl : string;
    readonly headers : HttpHeaders


    registerForm = this.formBuilder.group ({
        email : new FormControl('', [Validators.required, Validators.email]),
        username : new FormControl('', [Validators.required]),
        name : new FormControl('', [Validators.required]),
        password : new FormControl('', [Validators.required])
    })


    postObject = {
        operationType : 'save',
        userCustomer : this.registerForm.value
    }

    constructor(private formBuilder: FormBuilder, private httpClient : HttpClient){
        this.apiUrl = 'http://localhost:8082/api/user';
        this.headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
    }

    onSubmit(): void {
        this.postObject.userCustomer = this.registerForm.value
        console.log(this.postObject)
        if(this.registerForm.valid)
            this.httpClient.post(this.apiUrl, this.postObject, {headers : this.headers  }).subscribe(res => console.log(res))
        
    }
}