import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/shared/book.service';
import { Page } from 'src/app/common/page';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  page = new Page();
  cols = [];
  rows = [];
  constructor(private bookService: BookService) {

  }

  ngOnInit() {
    this.cols = [
      { prop: 'id', name: 'No' },
      { prop: 'bookName', name: 'Book Name', sortable: false },
      { prop: 'book_name', name: 'Book Name', sortable: false },
      { prop: 'author', name: 'Author', sortable: false },
      { prop: 'price', name: 'Price', sortable: false }



    ];
  }
  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.bookService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.number;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;

    });
  }
}
