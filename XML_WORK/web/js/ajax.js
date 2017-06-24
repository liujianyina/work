function setLocation() {
    var search_div = document.getElementById("search");

    var y = search_div.offsetTop;
    var x = search_div.offsetLeft;

    var point_div = document.getElementById("show");
    point_div.style.left = x + "px";

    point_div.style.top = (y + 16) + "px";

}

var xmlHttp;

function getMoreContext() {

    var keyword = document.getElementById("keyword").value;

    if (keyword == "") {
        clearContent();
        return;
    }

    xmlHttp = createXMLHttp();

    var url = "/admin/search?keyword=" + keyword;

    xmlHttp.open("GET", url, true);

    xmlHttp.onreadystatechange = callback;

    xmlHttp.send(null);

}

function callback() {
    if (xmlHttp.readyState == 4) {
        //200代表服务器响应成功
        if (xmlHttp.status == 200) {
            //交互成功，获得响应的数据，是文本格式
            var result = xmlHttp.responseText;

            //解析获得的数据
            var json = eval("(" + result + ")");
            //获得数据之后，就可以动态的展示数据
            //alert(json);
            setContent(json);
        }
    }
}

function createXMLHttp() {
    //对于大多数浏览器都适用
    var xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    //考虑浏览器的兼容性
    if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        if (!xmlHttp) {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
    return xmlHttp;
}

function setContent(contents) {

    clearContent();

    var size = contents.length;

    var ul = document.getElementById("show_ul");


    for (var i = 0; i < size; i++) {
        var text = contents[i];//代表的是json格式数据的第i个元素

        var li = document.createElement("li");


        li.onmouseover = function () {
            this.className = 'mouseOver';
        };

        li.onmouseout = function () {
            this.className = 'mouseOut';
        };

        li.onmousedown = function () {
            //点击一个关联的数据时，关联时自动设置为输入框的数据
            document.getElementById("keyword").value = this.innerText;
        };


        var text = document.createTextNode(text);

        li.appendChild(text);
        ul.appendChild(li);
    }
}

//清空之前的数据
function clearContent() {
    var ul = document.getElementById("show_ul");
    var size = ul.childNodes.length;
    for (var i = size - 1; i > 0; i--) {
        ul.removeChild(ul.childNodes[i]);
    }
}