# -*- coding: utf-8 -*-

# Testing program; to get the Centili library workin on Android.

__version__ = '1.0.0'

import kivy
kivy.require('1.8.0')
from kivy.app import App
from kivy.lang import Builder
from kivy.uix.tabbedpanel import TabbedPanel
from kivy.utils import platform
if platform == 'android':
    from jnius import autoclass


Builder.load_string( '''
<Panel>:
    do_default_tab: False
    TabbedPanelItem:
        BoxLayout:
            Button:
                text: 'Buy'
                on_press: root.buy()
            Button:
                text: 'test'

            ScrollView:
                Label:
                    text: 'test'

''')

class Panel(TabbedPanel):
	
    def buy(self):
        if platform == 'android':
            # we make use of Centili.java here
            Centili = autoclass('org.myapp.Centili')
            centili = Centili()
            # trigger the function in which the purchase process starts
            centili.purchaseCommit()
        else:
            pass

class MyApp(App):
    def build(self):
        panel = Panel()
        return panel

    # triggering the purchase sends the app in pause mode, so we return True here to enable the pause mode.
    def on_pause(self):
        return True

if __name__ == '__main__':
    MyApp().run()
