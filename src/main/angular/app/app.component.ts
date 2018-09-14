import {Component} from '@angular/core';
import {SecurityService} from "./services/security.service";
import {CurrentUser} from "./model/current-user";
import {Router} from "@angular/router";
import {StoriesService} from "./services/stories.service";
import {catchError, filter, switchMap, tap} from "rxjs/operators";
import {throwError} from "rxjs";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    currentUser: CurrentUser;
    showOpenStories: boolean;

    constructor(private securityService: SecurityService,
                private storiesService: StoriesService,
                private router: Router) {
        this.securityService.currentUser
            .pipe(
                catchError(err => {
                    this.currentUser = null;
                    return throwError(err);
                }),
                tap(user => this.currentUser = user),
                filter(user => user != null),
                filter(user => user.isInteressent),
                switchMap(user => this.storiesService.loadOpen(0, 1))
            )
            .subscribe(result => this.showOpenStories = result.stories.length > 0);
    }

    logout() {
        this.securityService.logout()
            .subscribe(res => this.router.navigateByUrl('/'));
    }
}
