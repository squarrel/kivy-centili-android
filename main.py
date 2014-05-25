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

    TabbedPanelItem:
        BoxLayout:
            Button:
                text: 'test'
            Button:
                text: 'test'
''')

class Panel(TabbedPanel):
	
    if platform == 'android':
        Centili = autoclass('org.myapp.Centili')
		
	
    def buy(self):
        if platform == 'android':
            pr = Centili.PurchaseRequest("421d33a2d56fe51207add3c07290f29a")
            pr.setOfflineModeEnabled(true)
            Centili.PurchaseManager.startPurchase(pr)
        else:
            pass

class MyApp(App):
    def build(self):
        panel = Panel()
        return panel

if __name__ == '__main__':
    MyApp().run()
