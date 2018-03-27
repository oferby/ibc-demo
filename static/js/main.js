function addHost(hostId) {
    cy.add([
        { group: "nodes", data: { id: hostId }, position: { x: 50, y: 50 }, classes: 'graphNode computeNode' }
    ])

}

var cy = cytoscape({
    container: document.getElementById('cy'), // container to render in
      style: [
        {
          selector: '.graphNode',
          style: {
            'background-fit': 'cover cover',
            'background-color': 'white'
          }
        },
        {
          selector: '.computeNode',
          style: {
            'background-image': 'images/pc.png'
          }
        },
        {
          selector: '.loadBalancer',
          style: {
            'background-image': 'images/lb.png'
          }
        },
        {
          selector: '.router',
          style: {
            'background-image': 'images/router.png'
          }
        },
        {
            selector: '.switch',
            style: {
                'background-image': 'images/switch.png'
            }
        },
        {
            selector: '.acl',
            style: {
                'background-image': 'images/acl.png'
            }
        },
        {
          selector: '.internet',
          style: {
            'background-image': 'images/world.png'
            }
        },
        {
          selector: '.subnet',
          style: {
            'background-image': 'images/cloud.png'
          }
        },
        {
          selector: '.gateway',
          style: {
            'background-image': 'images/gateway.png'
          }
        }
      ]
});

var stompClient = null;

function connect() {
    var socket = new SockJS('/intent-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/hint', function (hint) {
            inputTextHint(JSON.parse(hint.body).hint);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendIntent() {

    stompClient.send("/app/intent", {}, JSON.stringify({'text': $("#input").val()}));
}

function inputTextHint(inputText){

    $('#hint').text(inputText);

}

$(document).ready(function(){
    connect();
    $("#input").keyup(function(event){
//            console.log(event);
        console.log(event.which)
        if (event.which == 13) {
            addHost('n2');
        } else {
//            inputTextHint($("#input").val())
            sendIntent();

        }
    })

    })
// 32 space
// 13 enter
