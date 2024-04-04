import { API_BASE_URL } from '../constants';
import { Book } from '../types';

export const getBooks = async (): Promise<Book[]> => {
    const response = await fetch(`${API_BASE_URL}/books`, {
        method: 'GET',
    });
    const books = await response.json();
    console.log(books);
    return books;
};
