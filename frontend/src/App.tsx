import { useEffect, useState } from 'react';
import { getBooks } from './services/BookService';
import { Book } from './types';
import './App.css';

function App() {
    const [books, setBooks] = useState<Book[]>([]);

    useEffect(() => {
        const fetchBooks = async () => {
            setBooks(await getBooks());
        };
        fetchBooks();
    }, []);

    return (
        <div className="content">
            <div className="book-list">
                {books.map((book) => (
                    <div className="book-list-item" key={book.id}>
                        <p>{book.title}</p>
                        <p>{book.author}</p>
                    </div>
                ))}
            </div>
            <div className="book-details"></div>
        </div>
    );
}

export default App;
