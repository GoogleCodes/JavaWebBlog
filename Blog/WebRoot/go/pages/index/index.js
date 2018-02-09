//index.js

import { Main } from '../../utils/util.js'
let urls = require('../../utils/root.js');
let $ = new Main();

//获取应用实例
var app = getApp()
Page({
  data: {
    list: [],
    videoLayers: false,
    src: ['https://getcodeing.com/static/images/abc.jpg'],
    arr: [],
    backImage: 'https://www.getcodeing.com/images/1518097273335.jpg',
    eHeight: 0,
    showImage: false,
    videoID: -1,
    videoList: [
      {
        id: 1,
        poster: 'https://www.getcodeing.com/images/1518097273335.jpg',
        src: 'https://images.apple.com/media/cn/chinese-new-year/three-minutes/2018/f14ed516_730e_499a_8374_afd743848de6/films/three-minutes/iphone-three-minutes-tpl-cn-20180201_1280x720h.mp4'
      },
      {
        id: 2,
        poster: 'https://www.getcodeing.com/images/1518097273335.jpg',
        src: 'https://images.apple.com/media/cn/chinese-new-year/three-minutes/2018/f14ed516_730e_499a_8374_afd743848de6/films/three-minutes/iphone-three-minutes-tpl-cn-20180201_1280x720h.mp4'
      }
    ]
  },
  onLoad() {
    let that = this;
    that.getMessage();
  },

  playVideo(e) {
    let that = this;
    let index = e.currentTarget.dataset.index;
    let id = e.currentTarget.dataset.id;
    let list = that.data.videoList;
    for (let i in list) {
      let videoContext = wx.createVideoContext(list[i].id.toString());
      if (id == list[i].id) {
        videoContext.play();
        that.setData({
          videoID: id,
          videoLayers: true,
        })
      } else {
        videoContext.pause();
        that.setData({
          videoLayers: false,
        })
      }
      that.setData({
        videoID: id,
      })
    }
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
        let rep = '';
        for (let i in str) {
          rep = str[i];
          console.log(rep);
        }
        json = {
          image_path: 'https://www.getcodeing.com/' + rep,
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

  previewImage(e) {
    let that = this;
    var current = e.target.dataset.src;
    let arr = [], rep = '';
    let array = JSON.parse(e.target.dataset.arrays);
    for (let i in array) {
      rep = 'https://www.getcodeing.com/' + array[i];
      arr.push(rep);
    }
    wx.previewImage({
      current: current,
      urls: arr,
    })
  },

  /**
   * 监听页面滚动
   */
  onPageScroll(e) {
    
  }

})
