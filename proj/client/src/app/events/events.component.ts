import { EventSignupComponent } from './../event-signup/event-signup.component';
import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import dayGridPlugin from '@fullcalendar/daygrid';
import { DomSanitizer } from '@angular/platform-browser';

const gcalUrl = "https://calendar.google.com/calendar/b/1/embed?height=600&wkst=1&bgcolor=%23ffffff&ctz=America%2FNew_York&src=bmNzdS5lZHVfZXJma3NvczFndmpvbXNrdnI2azlvdTcxdG9AZ3JvdXAuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&color=%233366CC&showTitle=1&showNav=1&showDate=1&showPrint=0&showTabs=1&showCalendars=0";

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class EventsComponent implements OnInit {
  options: any;
  calendarPlugins = [dayGridPlugin]; // important!
  googeCalendarUrl;
  constructor(private dialogService: MatDialog, private sanitizer: DomSanitizer) {}
  ngOnInit() {
     this.googeCalendarUrl = this.sanitizer.bypassSecurityTrustResourceUrl(gcalUrl);
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
            start: '2019-09-02T17:30:00-05:00',
            end: '2019-09-02T18:30:00-05:00'
          },
          {
            id: 586,
            title: 'Family Promise',
            start: '2019-09-09T17:30:00-05:00',
            end: '2019-09-09T18:30:00-05:00'
          },
          {
            id: 587,
            title: 'Family Promise',
            start: '2019-09-16T17:30:00-05:00',
            end: '2019-09-16T18:30:00-05:00'
          },
          {
            id: 588,
            title: 'Family Promise',
            start: '2019-09-23T17:30:00-05:00',
            end: '2019-09-23T18:30:00-05:00'
          },
          {
            id: 589,
            title: 'Family Promise',
            start: '2019-09-30T17:30:00-05:00',
            end: '2019-09-30T18:30:00-05:00'
          },
          {
            id: 590,
            title: 'Haven House',
            start: '2019-09-28T08:30:00-05:00',
            end: '2019-09-28T10:30:00-05:00'
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
