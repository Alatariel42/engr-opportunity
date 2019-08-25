import { EventSignupComponent } from './../event-signup/event-signup.component';
import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { Options } from 'fullcalendar';
import { CalendarComponent } from 'ng-fullcalendar';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class EventsComponent implements OnInit {
  calendarOptions: Options;
  @ViewChild(CalendarComponent) calendar: CalendarComponent;
  constructor(private dialogService: MatDialog) {}
  ngOnInit() {
     this.calendarOptions = {
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
