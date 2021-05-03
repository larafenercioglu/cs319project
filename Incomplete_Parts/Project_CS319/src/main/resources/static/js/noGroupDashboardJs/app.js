$(document).ready(function () {
        getAllGroupsFromDb();
});

function getAllGroupsFromDb() {
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/getAllGroups";

    xhr.open("GET", url, true);
    xhr.onload = function () {

        if (this.status === 200) {
            console.log(this.responseText);
            var jsonData = JSON.parse(this.responseText);
            console.log(jsonData);
            //bu = this.responseText.groupId;
            jsonData.forEach(function(Result) {

                document.getElementById("other_group_module").innerHTML += '<div class="mb-2"> ' +
                    '<p class="pr-3" style="display:inline-block;"> Group-' + Result.groupId + '</p> ' +
                    '<button style="background-color: #7858a1;" class="btn btn-primary" type="submit"> Send Join Request</button> ' +
                    '</div>';

                console.log(Result.groupId);
            });
            /*
            <div class="mb-2">
                    <p class="pr-3" style="display: inline-block;">
                        -Group 1
                    </p>
                    <a href="#">Send Join Request</a>
                </div>
                <a href="javascript:{}" class="text-center py-3" >Send Join Request</a>
             */
        }
    }
    xhr.send();
}

/*
Progress bar
*/
$(".progress").each(function(){
  
    var $bar = $(this).find(".bar");
    var $val = $(this).find("span");
    var perc = parseInt( $val.text(), 10);
  
    $({p:0}).animate({p:perc}, {
      duration: 3000,
      easing: "swing",
      step: function(p) {
        $bar.css({
          transform: "rotate("+ (45+(p*1.8)) +"deg)", // 100%=180° so: ° = % * 1.8
          // 45 is to add the needed rotation to have the green borders at the bottom
        });
        $val.text(p|0);
      }
    });
});

/*
Calendar
*/
var events = [
  {'Date': new Date(2021, 6, 7), 'Title': 'Doctor appointment at 3:25pm.'},
  {'Date': new Date(2021, 6, 18), 'Title': 'New Garfield movie comes out!', 'Link': 'https://garfield.com'},
  {'Date': new Date(2021, 6, 27), 'Title': '25 year anniversary', 'Link': 'https://www.google.com.au/#q=anniversary+gifts'},
];
var settings = {};
var element = document.getElementById('caleandar');
caleandar(element, events, settings);


