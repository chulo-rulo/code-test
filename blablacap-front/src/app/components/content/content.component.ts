import { Component, OnInit, Injectable} from '@angular/core';
import { CommentsService } from 'src/app/services/comments/comments.service';
import { TripsService } from 'src/app/services/trips/trips.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
@Injectable()
export class ContentComponent implements OnInit {
  comments: any;
  trips: any;
  load: boolean | undefined; 
  newOrigin: any;
  newDestination: any;
  newDepart_date: any;

  constructor(
    public commentsService: CommentsService,
    public tripsService: TripsService,
    public router: Router
    ) { }

  ngOnInit(): void {
    this.commentsService.getLastComments().subscribe(resp=>{
        this.comments = resp;
        this.load = true;
        console.log(resp);
    },
    error=>{console.error(error)}
    )
  }

  onChangeSearch($event: any) {
    console.log($event);
    this.router.navigateByUrl('/lookajourney');
  }
}

