import { render, screen } from '@testing-library/react';
import  LightRow  from './LightRow';

describe("LightRow",()=>{
    const lights = [{id: 1, yellow: false, lighted: true},{id: 2, yellow: false, lighted: true},{id: 3, yellow: false, lighted: true},{id: 4, yellow: false, lighted: true}];
    const rowSize = lights.length;
    test('renders correctly', () => {
        render(<LightRow lights={lights}
            rowSize={rowSize}/>);
        const lightRowElement = screen.getByTestId("lightRow");
        expect(lightRowElement).toBeInTheDocument();
    });
    test('renders the correct number of lights', () => {
        render(<LightRow lights={lights}
            rowSize={rowSize}/>);
        const lightsListElement = screen.getAllByTestId("light");
        expect(lightsListElement).toHaveLength(rowSize);
        });
});