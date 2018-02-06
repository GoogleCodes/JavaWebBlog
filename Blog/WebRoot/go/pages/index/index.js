//index.js

import { Main } from '../../utils/util.js'
let urls = require('../../utils/root.js');
let $ = new Main();

//获取应用实例
var app = getApp()
Page({
  data: {
    list: [],
    src: ['https://getcodeing.com/static/images/abc.jpg'],
    arr: [],
  },
  onLoad() {
    let that = this;
    that.getMessage();
    that.orderSign();
  },

  onShareAppMessage() {
    return {
      title: 'Go',
      desc: '字母表!',
      path: '/pages/index/index'
    }
  },

  getMessage() {
    let that = this;
    wx.showLoading({
      title: '加载中。。。',
    })
    $.ajax({
      url: 'ImagesServlet',
      method: "POST",
      data: {},
    }).then((res) => {
      wx.hideLoading();
      let json = {}, arr = [];
      let pathArrays = '';
      if (res.items.length == 0) {
        wx.showToast({
          title: '暂时没有内容!',
          duration: 2000,
        })
        wx.clearStorageSync('wximage');
        return false;
      }
      for (let i in res.items) {
        pathArrays = res.items;
        let str = JSON.parse(res.items[i].image_path);
        let done = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\ROOT\\";
        let rep = '';
        for (let i in str) {
          rep = str[i].replace(done, "https://www.getcodeing.com/")
        }
        json = {
          image_path: rep.replace("\\", "/"),
          image_arrays: res.items[i].image_path,
          create_time: res.items[i].create_time,
          image_title: res.items[i].image_title
        };
        arr.push(json);
        that.setData({
          list: arr,
        });
        wx.setStorageSync("wximage", arr);
      }
    });
  },

  goPage(e) {
    wx.navigateTo({
      url: '../search/search?id' + 1,
    })
  },

  orderSign() {
    let that = this;
    var url = urls.wxopen + urls.access_token;
    // wx.request({
    //   url: url,
    //   data: {
    //     touser: wx.getStorageSync('user').openid,
    //     template_id: urls.template_id,
    //     page: '/pages/smart/smart',
    //     form_id: wx.getStorageSync('userInformation').formID,
    //     data: {
    //       "keyword1": {
    //         "value": '测试发送消息',
    //         "color": "#4a4a4a"
    //       },
    //       "keyword2": {
    //         "value": '智能灯已开启',
    //         "color": "#4a4a4a"
    //       }
    //     },
    //     emphasis_keyword: 'keyword1.DATA'
    //   },
    //   method: 'POST',
    //   success(res) {
    //     that.setData({ switchButton: true });
    //     //  发送数据
    //     tools.sendData('c2s_write', that.data.did, that.data.switchButton);
    //     $._Toast('发送成功', 'success');
    //   }
    // });
  },

  previewImage(e) {
    let that = this;
    var current = e.target.dataset.src;
    let arr = [], rep = '';
    let array = JSON.parse(e.target.dataset.arrays);
    let done = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\ROOT\\";
    for (let i in array) {
      rep = array[i].replace(done, "https://www.getcodeing.com/");
      rep = rep.replace("\\", "/");
      arr.push(rep);
    }
    wx.previewImage({
      current: current,
      urls: arr,
    })
  },

})
