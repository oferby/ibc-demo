function createGraph(){
    var g = cytoscape({
                container: document.getElementById('cy'), // container to render in
                  style: [
                    {
                      selector: '.graphNode',
                      style: {
                        'background-fit': 'cover cover',
                        'background-color': 'white',
                        'label': 'data(id)',
                        'text-valign': 'bottom'
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
                    },
                    {
                      selector: '.application',
                      style: {
                        'background-image': 'images/application.png'
                      }
                    },
                    {
                      selector: '.firewall',
                      style: {
                        'background-image': 'images/firewall.png'
                      }
                    },
                     {
                       selector: '.policy',
                       style: {
                         'background-image': 'images/policy.png'
                       }
                     }

                  ]
            });

    return g;

}

var cy = createGraph();

var lastCommand = '';

var stompClient = null;

function connect() {
    var socket = new SockJS('/intent-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/hint', function (hint) {
            var res = JSON.parse(hint.body);
            if (res.status == 'DONE') {
                sendIntent(res);
            } else if (res.status == 'LOCAL') {
                doLocal(res);
            } else if (res.status == 'INFO') {
                doInfo(res);
            } else {
                inputTextHint(res.hint);
            }

        });
        stompClient.subscribe('/topic/graph', function (intent) {
            var res = JSON.parse(intent.body);
            addToGraph(res);
        });
    });
}

function doLocal(res) {

    switch (res.intent) {

        case "clear":
            cy.destroy()
            console.log("graph destroyed");
            cy = createGraph();
            break;
         case "disconnectNodes":
            var edgeId = "#" + res.params.id;
            cy.$(edgeId).remove();
            break;

        default:
            console.log('unknown local intent');
            break;
    }

}

function sendinfo(info) {
    var $info = $('#info');
    $info.css('opacity', '0');
    $info.css('bottom', '0%');
    stompClient.send("/app/getHint", {}, JSON.stringify(info));
}


function doInfo(res) {

    if (res.params['type'] == 'option') {

        var $info = $('#info');
        $info.text(res.params['question'] + "  ");
        var $btn = null;
        var ss = res.params['options'].split(",");
        for (var i in ss) {
             var param = ss[i];
             $btn = $('<button/>', {
                text: param,
                id: 'btn_'+i,
                click: function () {
                    res.params[res.params['param']] = this.textContent;
                    sendinfo(res);
                }
            });

            $info.append($btn);
        }

        $info.css('opacity', '1');
        $info.css('bottom', '125%');

    } else if (res.params['type'] == 'yesno') {

        var $info = $('#info');
        $info.text(res.params['question'] + "  ");

        var $btn = null;

        $btn = $('<button/>', {
           text: "yes",
           id: 'btn_yes',
           click: function () {
               res.params[res.params['param']] = "yes";
               sendinfo(res);
           }
        });

        $info.append($btn);

        $btn = $('<button/>', {
           text: "no",
           id: 'btn_no',
           click: function () {
               res.params[res.params['param']] = "no";
               sendinfo(res);
           }
        });

        $info.append($btn);

        $info.css('opacity', '1');
        $info.css('bottom', '125%');

    } if (res.params['type'] == 'text') {


    }

}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function addToGraph(graphNode) {
    cy.add(graphNode);
    cy.layout({name:'breadthfirst'}).run()
//    cy.layout({name:'circle'}).run()
}

function getHint(isDone) {

    var msg = null;
    if (isDone) {
        msg = JSON.stringify({
                          'hint': $("#input").val(),
                          'status': 'ENTERED'
                      });
    } else {
        msg  = JSON.stringify({
                           'hint': $("#input").val(),
                           'status': 'HINT'
                       });
    }

    stompClient.send("/app/getHint", {}, msg);
}

function sendIntent(intent){
    console.log('Sending final intent')
    stompClient.send("/app/intent", {}, JSON.stringify(intent));
}

function inputTextHint(inputText){

    $('#hint').text(inputText);

}


function showAlert(alertText) {

    $("#warning").text($("#input").val());
    $('#warning').css('opacity', '1');
    $('#warning').css('bottom', '125%');

}


$(document).ready(function(){
    connect();
    $("#input").keyup(function(event){
//        console.log('key pressed: ' + event.which);

        if ($("#input").val().length > 0) {
            $('#hint').css('opacity', '1');
            $('#warning').css('opacity', '0');
            $('#warning').css('bottom', '0%');

        } else {
            $('#hint').css('opacity', '0');
        }

        if (event.which == 13) {
            lastCommand = $("#input").val();
            $('#hint').text('') ;
            $('#hint').css('opacity', '0');
            getHint(true);
            $("#input").val('');
        } else if (event.which == 32) {
            $("#input").val($('#hint').text() + ' ');
        } if (event.which == 38 || event.which == 40) {
            $("#input").val(lastCommand);
        } else {
            getHint(false);
        }
    })

    })
// 32 space
// 13 enter
