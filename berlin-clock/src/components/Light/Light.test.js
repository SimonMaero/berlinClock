import { render, screen } from '@testing-library/react';
import  Light  from './Light';

describe("Light",()=>{
    test('renders correctly', () => {
        render(<Light />);
        const lightElement = screen.getByTestId("light");
        expect(lightElement).toBeInTheDocument();
    });
    test('renders correctly if light is yellow and lighted', () => {
        render(<Light
            isYellow={true}
            isLighted={true}
        />);
        const lightElement = screen.getByTestId("light");
        expect(lightElement).toHaveClass("yellowLight","lightOn");
    });
    test('renders correctly if light is yellow and not lighted', () => {
        render(<Light
            isYellow={true}
            isLighted={false}
        />);
        const lightElement = screen.getByTestId("light");
        expect(lightElement).toHaveClass("yellowLight","lightOff");
    });
    test('renders correctly if light is red and lighted', () => {
        render(<Light
            isYellow={false}
            isLighted={true}
        />);
        const lightElement = screen.getByTestId("light");
        expect(lightElement).toHaveClass("redLight","lightOn");
    });
    test('renders correctly if light is red and not lighted', () => {
        render(<Light
            isYellow={false}
            isLighted={false}
        />);
        const lightElement = screen.getByTestId("light");
        expect(lightElement).toHaveClass("redLight","lightOff");
    });
    test('renders correctly if light is not alone in a row', () => {
        render(<Light
            rowSize={4}
        />);
        const lightElement = screen.getByTestId("light");
        expect(lightElement).toHaveClass("notSoloLight");
    });
    test('renders correctly if light is alone in a row', () => {
        render(<Light
            rowSize={1}
        />);
        const lightElement = screen.getByTestId("light");
        expect(lightElement).toHaveClass("soloLight");
    });

});