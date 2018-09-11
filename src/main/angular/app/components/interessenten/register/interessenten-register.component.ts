import {Component, OnChanges, SimpleChanges} from '@angular/core';
import {SecurityService} from "../../../services/security.service";
import {Router} from "@angular/router";
import {Credentials} from "../../../model/credentials";

@Component({
    selector: 'app-interessenten-register',
    templateUrl: './interessenten-register.component.html',
    styleUrls: ['./interessenten-register.component.css']
})
export class InteressentenRegisterComponent {
    data: { username: string, password: string, confirmPassword: string } = {
        username: '',
        password: '',
        confirmPassword: ''
    };

    registrationFailed: boolean = false;

    constructor(private securityService: SecurityService,
                private router: Router) {
    }

    onSubmit(form) {
        if(form.valid) {
            this.securityService.registerInteressent(this.data)
                .subscribe(res => this.router.navigateByUrl("/"),
                    err => this.registrationFailed = true);
        }
    }

    resetErrors(): void {
        this.registrationFailed = false;
    }
}
