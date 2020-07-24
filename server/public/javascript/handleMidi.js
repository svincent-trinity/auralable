console.log("js is here");
let currTime = new Date();
let start = currTime.getTime();

console.log(start);

let playBackArray = [];

let notestoplay = [];
let notescompplays = [];

let level = 1;

let playing = true;


let noteInput = document.getElementById("notePlayed");
let notesTable = document.getElementById("notesTable");
let row1 = notesTable.insertRow(1);
let row2 = notesTable.insertRow(2);
let row3 = notesTable.insertRow(3);
let row4 = notesTable.insertRow(4);


/*let kick = document.getElementById("kick");
let snare = document.getElementById("snare");
let hihat = document.getElementById("hihat");
let ride = document.getElementById("ride");
let stick = document.getElementById("stick-hit");
let crash = document.getElementById("crash");
*/
let C4 = document.getElementById("C4");
let D4 = document.getElementById("D4");
let E4 = document.getElementById("E4");
let F4 = document.getElementById("F4");
let G4 = document.getElementById("G4");
let A4 = document.getElementById("A4");
let B4 = document.getElementById("B4");
let C5 = document.getElementById("C5");



noteInput.value = "";
navigator.requestMIDIAccess()
    .then(onMIDISuccess, onMIDIFailure);

function play() {

	console.log("button pressed")
	document.getElementById("levelOn").innerHTML = "You are on level " + level + " of C major pentatonic drill!";
    if(level === 1) {
    	notestoplay = [60, 64, 67, 72];
    	//notescompplays = notestoplay;
    	//console.log(notestoplay[1])
        row1.insertCell(0).innerHTML = "?"
     	row2.insertCell(0).innerHTML = "?"
        row3.insertCell(0).innerHTML = "?"
		row4.insertCell(0).innerHTML = "?"

    	
    } if(level > 1) {
        for(let i=0; i<4; i++) {
        	let nextnote= Math.floor(Math.random() * 6);
        	if(nextnote === 0) {
        		notestoplay.push(60)
        	} else if (nextnote === 1) {
        		notestoplay.push(62)
        	}  else if (nextnote === 2) {
        		notestoplay.push(64)
        	} else if(nextnote === 3) {
        		notestoplay.push(67)
        	} else if(nextnote === 4) {
        		notestoplay.push(69)
        	} else if(nextnote === 5) {
        		notestoplay.push(72)
        	}
        	if(i === 0) {
        		row1.deleteCell(0)
        		row1.insertCell(0).innerHTML = "?"
        	}
        	if(i === 1) {
        		row2.deleteCell(0)

        		row2.insertCell(0).innerHTML = "?"
        	}
             if(i === 2) {
                row3.deleteCell(0)

        		row3.insertCell(0).innerHTML = "?"
        	}
            if(i === 3) {
                row4.deleteCell(0)

        		row4.insertCell(0).innerHTML = "?"
        	}
            
        }

    }
            notescompplays = [];//= notestoplay;
        for(let i=0; i < notestoplay.length; i++) {
        	notescompplays.push(notestoplay[i])
        }
        //document.getElementById("lvlbutton").innerHTML = "Next Level"
            level += 1;
}

setInterval(function(){ 
	//alert("Playing note");
	if(notescompplays.length > 0) {
		playing = true;
		playNote(notescompplays[0], true)
		notescompplays.shift()
	} else {
		playing = false;
	}
}, 1000);

function handleRecording() {
	let lastTime = 0;
    for(let i = 0; i < playBackArray.length; i++) {
    	if(i%2 == 0) {
    	    playNote(playBackArray[i], true);
    	    //sleep(100)//playBackArray[i+1] - lastTime)
    	    //lastTime = playBackArray[i+1];
        } 

    }
}

function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}


function deleteRecording() {
	playBackArray = [];
}


function stopAudio(audio) {
	audio.pause();
	audio.currentTime = 0;
	/*var sound = audio;
	var fadePoint = sound.duration - 2; 

    var fadeAudio = setInterval(function () {

        // Only fade if past the fade out point or not at zero already
        if ((sound.currentTime >= fadePoint) && (sound.volume <= 0.0)) {
            sound.volume -= 0.1;
        }
        // When volume at zero stop all the intervalling
        if (sound.volume <= 0.0) {
            clearInterval(fadeAudio);
        }
    }, 200);*/
}

function onMIDISuccess(midiAccess) {
    console.log(midiAccess);

    /*var inputs = midiAccess.inputs;
    var outputs = midiAccess.outputs;*/
        for (var input of midiAccess.inputs.values()) {
        input.onmidimessage = getMIDIMessage;
    }
}

function onMIDIFailure() {
    console.log('Could not access your MIDI devices.');
}

function getMIDIMessage(midiMessage) {
    console.log(midiMessage.data);
    if(midiMessage.data[0] == 144) {
    	console.log("You played note " + midiMessage.data[1]);
    	noteInput.value = midiMessage.data[1];
    	playBackArray.push(noteInput.value);
    	currTime = new Date();
    	console.log(currTime.getTime() - start);
    	playBackArray.push(currTime.getTime() - start);
    	playNote(noteInput.value, true);
    	console.log(playBackArray);
    } /*else if (midiMessage.data[0] == 128) {
    	playNote(noteInput.value, false)
    }*/
}

function getMIDIMessageArray(messageArray) {
	if(messageArray[0] == 144) {
		console.log("You played note " + messageArray[1]);
    	noteInput.value = messageArray[1];
    	playBackArray.push(noteInput.value);
    	currTime = new Date();
    	console.log(currTime.getTime() - start);
    	playBackArray.push(currTime.getTime() - start);
    	playNote(noteInput.value, true);
    	console.log(playBackArray);
	}
}

function getNameFromNumber(noteIn) {
    if(noteIn == 60) {
    	return "C4"
    } else if(noteIn == 62) {
    	return "D4"
    } else if (noteIn == 64) {
    	return "E4"
    } else if (noteIn == 65) {
    	return "F4"
    } else if (noteIn == 67) {
    	return "G4"
    } else if (noteIn == 69) {
    	return "A4"
    } else if (noteIn == 71) {
    	return "B4"
    } else if (noteIn == 72) {
    	return "C5"
    }
}

function playNote(noteIn, onOrOff) {
	console.log(notestoplay[0] + " " + !playing)
	if (noteIn == notestoplay[0] && !playing) {
		console.log("equals")
		if (notestoplay.length === 4) {
    		row1.deleteCell(0)
    		row1.insertCell(0).innerHTML = getNameFromNumber(noteIn)
		} else if(notestoplay.length === 3) {
    		row2.deleteCell(0)
    		row2.insertCell(0).innerHTML = getNameFromNumber(noteIn)
		} else if(notestoplay.length === 2) {
    		row3.deleteCell(0)
    		row3.insertCell(0).innerHTML = getNameFromNumber(noteIn)
		} else if(notestoplay.length === 1) {
    		row4.deleteCell(0)
    		row4.insertCell(0).innerHTML = getNameFromNumber(noteIn)
		}

		notestoplay.shift()

	}
	if (noteIn == 60) {
		stopAudio(C4);
		if (onOrOff) C4.play();

	}else if (noteIn == 62) {
		stopAudio(D4);
		if (onOrOff) D4.play();

	}else if (noteIn == 64) {
		stopAudio(E4);
		if (onOrOff) E4.play();
	}else if (noteIn == 65) {
		stopAudio(F4);
		if (onOrOff) F4.play();

	}else if (noteIn == 67) {
		stopAudio(G4);
		if (onOrOff) G4.play();

	}else if (noteIn == 69) {
		stopAudio(A4);
		if (onOrOff) A4.play();

	}else if (noteIn == 71) {
		stopAudio(B4);
		if (onOrOff) B4.play();
	} else if (noteIn == 72) {
		stopAudio(C5);
		if (onOrOff) C5.play();
	} 


}