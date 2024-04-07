import { Book } from '../../types';
import style from './style.module.css';

type BookListProps = {
    books: Book[];
    selectedBook: Book | null;
    setSelectedBook: (book: Book | null) => void;
};

export default function BookList({
    books,
    selectedBook,
    setSelectedBook,
}: Readonly<BookListProps>) {
    return (
        <div className={style.bookList}>
            {books.map((book) => (
                <div
                    className={
                        selectedBook?.id === book.id
                            ? style.bookListItemSelected
                            : style.bookListItem
                    }
                    role="button"
                    tabIndex={-1}
                    key={book.id}
                    onClick={() => setSelectedBook(book)}
                >
                    <p>{book.title}</p>
                    <p>{book.author}</p>
                </div>
            ))}
        </div>
    );
}
