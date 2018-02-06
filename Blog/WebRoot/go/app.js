//app.js

let urls = require('utils/root.js');

App({
  onLaunch() {

    //获取openid
    var user = wx.getStorageSync('wxuser') || {};
    //url
    let url = urls.LoginUri + '?appid=' + urls.Appid + '&secret=' + urls.Secrent;

    if (typeof user == 'object' && !user.openid && (user.expires_in || Date.now()) < (Date.now() + 600)) {
      wx.login({
        success(res) {
          if (res.errMsg == 'login:ok') {
            wx.request({
              url: 'http://localhost:8080/WeChatServlet',
              method: 'POST',
              data: {
                code: res.code
              },
              header: {
                'content-type': 'application/json',
                'content-type': 'application/x-www-form-urlencoded'
              },
              success(res) {
                let json = JSON.parse(res.data);
                wx.setStorageSync('wxUserInfo', json)
              },
            })
          } else {
            wx.showToast({
              title: '登录失败!',
              duration: 2000,
            })
          }
        }
      })
    }
  },

  getUserInfo(cb) {
    var that = this
    if (this.globalData.userInfo) {
      typeof cb == "function" && cb(this.globalData.userInfo)
    } else {
      //调用登录接口
      wx.getUserInfo({
        withCredentials: false,
        success(res) {
          that.globalData.userInfo = res.userInfo
          typeof cb == "function" && cb(that.globalData.userInfo)
        }
      })
    }
  },

  globalData: {
    userInfo: null
  }
})
