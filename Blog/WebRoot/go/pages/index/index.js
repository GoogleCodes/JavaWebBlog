//index.js

import { Main } from '../../utils/util.js'
let $ = new Main();

//获取应用实例
var app = getApp()
Page({
  data: {
    list: [],
    src: ['https://getcodeing.com/static/images/abc.jpg']
  },
  onLoad() {
    let that = this;
    that.getMessage();
  },

  getMessage() {
    let that = this;
    wx.showLoading({
      title: '加载中。。。',
    })
    $.ajax({
      url: 'BankServlet',
      method: "GET",
      data: {},
    }).then((res) => {
      wx.hideLoading();
      that.setData({
        list: res.items
      });
      wx.setStorageSync('list', that.data.list);
    });
  },

  goPage(e) {
    wx.navigateTo({
      url: '../search/search?id' + 1,
    })
  },

  previewImage(e) {
    var current = e.target.dataset.src;
    let that = this;
    wx.previewImage({
      current: current,
      urls: that.data.src,
    })
  }

})
