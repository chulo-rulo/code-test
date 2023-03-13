import { Component, OnInit } from '@angular/core';
import { faCity, faRoadBridge, faUser } from '@fortawesome/free-solid-svg-icons';
import { CommentsService } from 'src/app/services/comments/comments.service';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {

  comments: any;
  load: boolean | undefined;
  roadIcon = faRoadBridge;
  cityIcon = faCity;
  userIcon = faUser;

  constructor(
    public commentsService: CommentsService
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
  }


