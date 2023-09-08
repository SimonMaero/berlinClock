import React from "react";
import "./Light.css"

class Light extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            lightId: props.lightId,
            isYellow: props.isYellow,
            isLighted: props.isLighted,
            rowSize: props.rowSize
        };
    }

    render() {

        //Light style select based on the rowSize and state (color and lighted or not) 
        const styleClass = `light ${this.props.rowSize==1 ? 'soloLight' : 'notSoloLight'} ${this.props.isYellow ? 'yellowLight' : 'redLight'} ${this.props.isLighted ? 'lightOn' : 'lightOff'} `;
        const style = {width: `${100 / this.props.rowSize}%`};

        return (    
                    <div data-testid="light" className={styleClass} style={style}> </div>
        );
    }
}

export default Light;