function gwtjsplumbdemo(prevElem,currElem) {
	   
   alert("Hellooo!!, I came here"); 
  
  
   jsPlumb.bind("ready", function() {
	   
   jsPlumb.connect({source:prevElem, target:currElem,
       anchors:["Right", "Left" ],
	     paintStyle: { strokeStyle: "#3366FF", lineWidth: 1 },
       connector: ["Flowchart", { curviness: 100}],
       connectorStyle: [{ lineWidth: 1, strokeStyle: "#3366FF" }],
       hoverPaintStyle: { strokeStyle: "#3366FF", lineWidth: 8 }
       });
   });
  
 }