//app.js

let urls = require('utils/root.js');

App({
  onLaunch() {

    //获取openid
    var user = wx.getStorageSync('wxuser') || {};
    //url
    let url = urls.LoginUri + '?appid=' + urls.Appid + '&secret=' + urls.Secrent;

    // if (typeof user == 'object' && !user.openid && (user.expires_in || Date.now()) < (Date.now() + 600)) {
    //   wx.login({
    //     success(res) {
    //       if (res.errMsg == 'login:ok') {
    //         //  发起请求
    //         wx.request({
    //           url: url + '&js_code=' + res.code + '&grant_type=authorization_code',
    //           success(res) {
    //             let obj = {};
    //             obj.openid = res.data.openid;
    //             obj.expires_in = Date.now() + res.data.expires_in;
    //             wx.setStorageSync('wxuser', obj);

    //             //调用API从本地缓存中获取数据
    //             var logs = wx.getStorageSync('logs') || []
    //             logs.unshift(Date.now())
    //             wx.setStorageSync('logs', logs)
    //           }
    //         })
    //       } else {
    //         wx.showToast({
    //           title: '登录失败!',
    //           duration: 2000,
    //         })
    //       }
    //     }
    //   })
    // }
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
