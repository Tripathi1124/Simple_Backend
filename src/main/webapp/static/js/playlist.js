"use strict";

let audioElement = document.getElementsByTagName("audio")[0];

/*function myFunc() {
    document.getElementsByTagName("li")[0].style.display="none";
    audioElement.classList.toggle("show");
}*/

// <video> is used for top-level audio documents as well
// 1. Handle fullscreen mode;
// 2. Send keystrokes to the video element if the body element is focused,
//    to be received by the event listener in videocontrols.xml.
/*document.getElementsByClassName("play").addEventListener("click", ev => {
  if (ev.synthetic) // prevent recursion
    return;

  // Check if the video element is focused, so it already receives
  // keystrokes, and don't send it another one from here.
  if (document.activeElement == audioElement)
    return;

  let newEvent = new MouseEvent("click", ev);
  newEvent.synthetic = true;
  audioElement.dispatchEvent(newEvent);
});*/

