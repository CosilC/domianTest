function get(url, param) {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: url + (param ? $.param(param) : ''),
            dataType: 'json',
            success: function (res) {
                resolve(res)
            },
            fail: function (err) {
                reject(err);
            }
        })
    })
}

function post(url, data) {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: url,
            data: data,
            dataType: 'json',
            type: 'post',
            success: function (res) {
                resolve(res)
            },
            fail: function (err) {
                reject(err);
            }
        })
    })
}


function getAllNodes() {
    return get("/getAllNodes");
}

function getNodeResult(data) {
    return post("/getNodeResult", data);
}

function getIpArea(ip) {
    return post("/getIpArea", {targetIp: ip});
}