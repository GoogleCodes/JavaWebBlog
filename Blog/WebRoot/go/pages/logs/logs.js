//logs.js

import { Main } from '../../utils/util.js'
let main = new Main();

Page({
  data: {
    logs: []
  },
  onLoad: function () {
    this.setData({
      logs: (wx.getStorageSync('logs') || []).map(function (log) {
        return main.formatTime(new Date(log))
      })
    })
  }
})
