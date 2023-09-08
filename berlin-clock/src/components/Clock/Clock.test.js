import { render, screen } from '@testing-library/react';
import user from '@testing-library/user-event';
import  Clock  from './Clock';
import { act } from 'react-dom/test-utils';

describe("Clock",()=>{
    test('renders correctly', () => {
    render(<Clock />);
        const timeEntryElement = screen.getByRole("textbox", {
            name:'please enter digital time to convert :'
        });
        expect(timeEntryElement).toBeInTheDocument();
        const berlinTimeEntryElement = screen.getByRole("textbox", {
            name:'please enter berlin time to convert :'
        });
        expect(berlinTimeEntryElement).toBeInTheDocument();
        const submitButtonElement = screen.getByRole("button", {
            name:'Submit'
        });
        expect(submitButtonElement).toBeInTheDocument();
    });
    
    test('gives an error when backend is KO', async () => {
        
            render(<Clock />);
        
        const timeErrorElement = await screen.findByTestId("timeError");
        expect(timeErrorElement).toBeInTheDocument();
        });

});
