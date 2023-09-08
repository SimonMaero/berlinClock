import React from "react";
import "./LightRow.css"
import "../Light/Light.js"
import Light from "../Light/Light.js";

class SingleMinutesRow extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            lights: this.props.lights,
            rowSize: this.props.rowSize
        };
    }

    render() {

        //LightRow style select based on the rowSize
        const styleClass = `${this.props.rowSize==1 ? 'soloLightRowBanner' : 'lightsRowBanner'}`;

        return ( <div data-testid="lightRow" className={styleClass}>
                    
                    {this.props.lights.map((light) =>
                    <Light
                        key={light.id}
                        isYellow={light.yellow}
                        isLighted={light.lighted}
                        rowSize={this.state.rowSize}
                    /> )}   
                  
                </div>

        )
    }
}

export default SingleMinutesRow;