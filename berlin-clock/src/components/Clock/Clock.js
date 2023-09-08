import React from "react";
import "./Clock.css"
import axios from "axios";
import LightRow from "../LightRow/LightRow";

const validDigitalTime = new RegExp('^(2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$');
const validBerlinTime = new RegExp('[O|R|Y]{24}');

class Clock extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            timeEntry: "00:00:00",
            berlinTimeEntry:"",
            timeEntryError: "",
            singleMinutesRowLights: [],
            singleMinutesRowSize: 4,
            fiveMinutesRowLights: [],
            fiveMinutesRowSize: 11,
            singleHoursRowLights: [],
            singleHoursRowSize: 4,
            fiveHoursRowLights: [],
            fiveHoursRowSize: 4,
            secondsRowLights: [],
            secondsRowSize: 1,
            berlinTimeConvertedToDigital: ""
        };
    }
    
    //before having an user entry, display default timeEntry on the Berlin-clock
    componentDidMount() {
        //call for the singleMinuteRow
        axios({
            method: "POST",
            
            url: "http://localhost:8080/timeConversion/berlinTime/singleMinutesRow",
            data: {
                digitalTime: this.state.timeEntry
            }
        }).then((response) => {
            this.setState({singleMinutesRowLights: response.data});
        }).catch((response) => {
            this.setState({timeEntryError: "Backend Error"});
        });
        //call for the fiveMinuteRow
            axios({
            method: "POST",
           
            url: "http://localhost:8080/timeConversion/berlinTime/fiveMinutesRow",
            data: {
                digitalTime: this.state.timeEntry
            }
        }).then((response) => {
            this.setState({fiveMinutesRowLights: response.data});
        }).catch((response) => {
            this.setState({timeEntryError: "Backend Error"});
        });
        //call for the singleHoursRow
        axios({
            method: "POST",
          
            url: "http://localhost:8080/timeConversion/berlinTime/singleHoursRow",
            data: {
                digitalTime: this.state.timeEntry
            }
        }).then((response) => {
            this.setState({singleHoursRowLights: response.data});
        }).catch((response) => {
            this.setState({timeEntryError: "Backend Error"});
        });
         //call for the fiveHoursRow
         axios({
            method: "POST",
           
            url: "http://localhost:8080/timeConversion/berlinTime/fiveHoursRow",
            data: {
                digitalTime: this.state.timeEntry
            }
        }).then((response) => {
            this.setState({fiveHoursRowLights: response.data});
        }).catch((response) => {
            this.setState({timeEntryError: "Backend Error"});
        });
         //call for the secondsRow
         axios({
            method: "POST",
           
            url: "http://localhost:8080/timeConversion/berlinTime/secondsRow",
            data: {
                digitalTime: this.state.timeEntry
            }
        }).then((response) => {
            this.setState({secondsRowLights: response.data});
        }).catch((response) => {
            this.setState({timeEntryError: "Backend Error"});
        });
    }

    onChangeHandler = (event) => {
        let name = event.target.name;
        let value = event.target.value;
        this.setState({[name] : value});
    }

    onSubmitTimeEntry = (e) => {
        e.preventDefault();
        if (this.state.timeEntry){ 
            //digital time entry case
            if (validDigitalTime.test(this.state.timeEntry)) {
                //call for the singleMinuteRow
                axios({
                    method: "POST",
                
                    url: "http://localhost:8080/timeConversion/berlinTime/singleMinutesRow",
                    data: {
                        digitalTime: this.state.timeEntry
                    }
                }).then((response) => {
                    this.setState({singleMinutesRowLights: response.data});
                }).catch((response) => {
                    this.setState({timeEntryError: "Backend Error"});
                });
                //call for the fiveMinuteRow
                axios({
                    method: "POST",
                
                    url: "http://localhost:8080/timeConversion/berlinTime/fiveMinutesRow",
                    data: {
                        digitalTime: this.state.timeEntry
                    }
                }).then((response) => {
                    this.setState({fiveMinutesRowLights: response.data});
                }).catch((response) => {
                    this.setState({timeEntryError: "Backend Error"});
                });
                //call for the singleHoursRow
                axios({
                    method: "POST",
                 
                    url: "http://localhost:8080/timeConversion/berlinTime/singleHoursRow",
                    data: {
                        digitalTime: this.state.timeEntry
                    }
                }).then((response) => {
                    this.setState({singleHoursRowLights: response.data});
                }).catch((response) => {
                    this.setState({timeEntryError: "Backend Error"});
                });
                 //call for the fiveHoursRow
                axios({
                    method: "POST",
                  
                    url: "http://localhost:8080/timeConversion/berlinTime/fiveHoursRow",
                    data: {
                        digitalTime: this.state.timeEntry
                    }
                }).then((response) => {
                    this.setState({fiveHoursRowLights: response.data});
                }).catch((response) => {
                    this.setState({timeEntryError: "Backend Error"});
                });
                //call for the secondsRow
                axios({
                    method: "POST",
                 
                    url: "http://localhost:8080/timeConversion/berlinTime/secondsRow",
                    data: {
                        digitalTime: this.state.timeEntry
                    }
                }).then((response) => {
                    this.setState({secondsRowLights: response.data});
                }).catch((response) => {
                    this.setState({timeEntryError: "Backend Error"});
                });
            //berlin time entry case
            } else {this.setState({timeEntryError: "Correct digital time format is 24h as XX:XX:XX"})}
            if(this.state.berlinTimeEntry){
            if (validBerlinTime.test(this.state.berlinTimeEntry)) {
                //call for the berlinTime conversion
                axios({
                    method: "POST",
                  
                    url: "http://localhost:8080/timeConversion/digitalTime",
                    data: {
                        berlinTime: this.state.berlinTimeEntry
                    }
                }).then((response) => {
                    this.setState({berlinTimeConvertedToDigital: response.data.digitalTime});
                }).catch((response) => {
                    this.setState({timeEntryError: "Backend Error"});
                });
            } else {this.setState({timeEntryError: "Correct berlin time format is 24 MAJ letters"})}
        }
        }
    }

    render() {

        return ( 
                <div className="berlinClock">
                    <div className="timeEntryBanner">

                        <div className="timeEntryForm">
                            <form onSubmit={this.onSubmitTimeEntry}>
                                <p>
                                    <label htmlFor="timeEntry"> please enter digital time to convert : </label>
                                    <input name="timeEntry" id="timeEntry" type="text" onChange={this.onChangeHandler}></input>
                                </p>
                                <p>
                                    <label htmlFor="berlinTimeEntry"> please enter berlin time to convert : </label>
                                    <input name="berlinTimeEntry" id="berlinTimeEntry" type="text" onChange={this.onChangeHandler}></input>
                                </p>
                                <p>
                                    <button className="submit-btn" type="submit"> Submit</button>
                                </p>
                                {
                                    this.state.berlinTimeConvertedToDigital && <p data-testid="berlinTimeConverted" >{this.state.berlinTimeConvertedToDigital}</p>
                                }
                                {
                                    this.state.timeEntryError && <p data-testid="timeError" >{this.state.timeEntryError}</p>
                                }
                            </form>
                        </div>

                    </div>
                    <LightRow lights={this.state.secondsRowLights}
                                    rowSize={this.state.secondsRowSize}
                    />
                    <LightRow lights={this.state.fiveHoursRowLights}
                                    rowSize={this.state.fiveHoursRowSize}
                    />
                    <LightRow lights={this.state.singleHoursRowLights}
                                    rowSize={this.state.singleHoursRowSize}
                    />
                    <LightRow lights={this.state.fiveMinutesRowLights}
                                    rowSize={this.state.fiveMinutesRowSize}
                    />
                    <LightRow lights={this.state.singleMinutesRowLights}
                                    rowSize={this.state.singleMinutesRowSize}
                    />
                </div>
        )
    }
}

export default Clock;