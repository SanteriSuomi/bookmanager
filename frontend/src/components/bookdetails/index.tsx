import { useEffect, useState } from 'react';
import { Book } from '../../types';
import style from './style.module.css';
import { deleteBookById, postBook, putBook } from '../../services/BookService';

type BookDetailsProps = {
    selectedBook: Book | null;
    updateLocalBook: (book: Book) => void;
    addLocalBook: (book: Book) => void;
    removeLocalBookById: (id: string) => void;
};

export default function BookDetails({
    selectedBook,
    updateLocalBook,
    addLocalBook,
    removeLocalBookById,
}: Readonly<BookDetailsProps>) {
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [description, setDescription] = useState('');

    useEffect(() => {
        setTitle(selectedBook?.title ?? '');
        setAuthor(selectedBook?.author ?? '');
        setDescription(selectedBook?.description ?? '');
    }, [selectedBook]);

    return (
        <div className={style.bookDetails}>
            <div className={style.bookDetailsInput}>
                <label htmlFor="title">Title*</label>
                <input
                    type="text"
                    id="title"
                    onChange={(e) => setTitle(e.target.value)}
                    value={title}
                />
            </div>

            <div className={style.bookDetailsInput}>
                <label htmlFor="author">Author*</label>
                <input
                    type="text"
                    id="author"
                    onChange={(e) => setAuthor(e.target.value)}
                    value={author}
                />
            </div>

            <div className={style.bookDetailsInput}>
                <label htmlFor="description">Description</label>
                <textarea
                    id="description"
                    onChange={(e) => setDescription(e.target.value)}
                    value={description}
                ></textarea>
            </div>

            <div>*required</div>

            <div className={style.bookDetailsButtons}>
                <button
                    onClick={() =>
                        postBook({ title, author, description }).then(
                            (newBook) => addLocalBook(newBook)
                        )
                    }
                >
                    Save New
                </button>
                <button
                    disabled={!selectedBook}
                    onClick={() =>
                        putBook({
                            id: selectedBook?.id,
                            title,
                            author,
                            description,
                        }).then((updatedBook) => updateLocalBook(updatedBook))
                    }
                >
                    Save
                </button>
                <button
                    disabled={!selectedBook}
                    onClick={() =>
                        deleteBookById(selectedBook?.id ?? '').then(() =>
                            removeLocalBookById(selectedBook?.id ?? '')
                        )
                    }
                >
                    Delete
                </button>
            </div>
        </div>
    );
}
