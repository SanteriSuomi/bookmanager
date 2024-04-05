import { API_BASE_URL } from '../constants';
import { Book } from '../types';

export const getBooks = async (): Promise<Book[]> => {
    const response = await fetch(`${API_BASE_URL}/books`, {
        method: 'GET',
    });
    return await response.json();
};

export const postBook = async (book: Book): Promise<Book> => {
    const response = await fetch(`${API_BASE_URL}/books`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify([book]),
    });
    const newBooks = await response.json();
    return newBooks[0];
};

export const putBook = async (book: Book): Promise<Book> => {
    const response = await fetch(`${API_BASE_URL}/book`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(book),
    });
    return await response.json();
};

export const deleteBookById = async (id: string): Promise<void> => {
    await fetch(`${API_BASE_URL}/book/${id}`, {
        method: 'DELETE',
    });
};
