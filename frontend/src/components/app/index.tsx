import { useEffect, useState } from 'react';
import { getBooks } from '../../services/BookService';
import { Book } from '../../types';
import BookDetails from '../bookdetails';
import BookList from '../booklist';
import style from './style.module.css';

function App() {
    const [books, setBooks] = useState<Book[]>([]);
    const [selectedBook, setSelectedBook] = useState<Book | null>(null);

    const updateLocalBook = (book: Book) => {
        const newBooks = books.map((curBook) =>
            curBook.id === book.id ? book : curBook
        );
        setBooks(newBooks);
    };

    const addLocalBook = (book: Book) => {
        setBooks([...books, book]);
        setSelectedBook(book);
    };

    const removeLocalBookById = (id: string) => {
        setBooks(books.filter((book) => book.id !== id));
        setSelectedBook(null);
    };

    useEffect(() => {
        const fetchBooks = async () => {
            setBooks(await getBooks());
        };
        fetchBooks();
    }, []);

    return (
        <div className={style.content}>
            <BookList
                books={books}
                selectedBook={selectedBook}
                setSelectedBook={setSelectedBook}
            ></BookList>
            <BookDetails
                selectedBook={selectedBook}
                updateLocalBook={updateLocalBook}
                addLocalBook={addLocalBook}
                removeLocalBookById={removeLocalBookById}
            ></BookDetails>
        </div>
    );
}

export default App;
