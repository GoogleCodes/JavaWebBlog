
let urls = require('root.js');

class Main {
  ajax(data) {
    return new Promise((resolve, reject) => {
      wx.request({
        url: urls.ServletUrl + data.url,
        data: data.data,
        method: data.method,
        header: {
          'content-type': 'application/json',
          'content-type': 'application/x-www-form-urlencoded'
        },
        success(res) {
          resolve(res.data)
        },
        fail(err) {
          reject(err)
        }
      })
    })
  }

  uploadAjax(data) {
    wx.showLoading({
      title: '上传中!!!',
    })
    console.log(urls.ServletUrl + data.url);
    return new Promise((resolve, reject) => {
      wx.uploadFile({
        url: urls.ServletUrl + data.url, // urls.ServletUrl
        filePath: data.filePath,
        name: data.name, // "file",
        header: {
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'GET, POST, PUT',
          'Access-Control-Allow-Headers': 'Origin, X-Requested - With, Content-Type, Accept'
        },
        success(res) {
          wx.hideLoading();
          resolve(res);
        },
        fail(err) {
          wx.showModal({
            title: '警告!',
            content: err.errMsg,
            showCancel: false,
          })
          wx.hideLoading();
        }
      })
    })
  }

  formatTime(date) {
    var year = date.getFullYear()
    var month = date.getMonth() + 1
    var day = date.getDate()

    var hour = date.getHours()
    var minute = date.getMinutes()
    var second = date.getSeconds()

    return [year, month, day].map(this.formatNumber).join('/') + ' ' + [hour, minute, second].map(this.formatNumber).join(':')
  }

  formatNumber(n) {
    n = n.toString()
    return n[1] ? n : '0' + n
  }
}


module.exports = {
  Main: Main
}