import { EventSignupComponent } from './../event-signup/event-signup.component';
import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import dayGridPlugin from '@fullcalendar/daygrid';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class EventsComponent implements OnInit {
  options: any;
  calendarPlugins = [dayGridPlugin]; // important!
  constructor(private dialogService: MatDialog) {}
  ngOnInit() {
     this.options = {
        editable: false,
        eventLimit: false,
        header: {
          left: 'prev,next today',
          center: 'title',
          right: 'month,agendaWeek,agendaDay,listMonth'
        },
        events: [
          {
            id: 585,
            title: 'Family Promise',
            start: '2019-08-28T18:30:00+05:00',
            end: '2019-08-28T19:30:00+05:00'
          }
        ]
      };
  }

  eventClick(event) {
    const dialogRef = this.dialogService.open(EventSignupComponent, {data: event});
    dialogRef.afterClosed().subscribe(result => {

    });
  }

}
