Fix missing environment paths
===

Sometimes IDEA won't properly detect the environment paths properly.
This can happen becuase of many reasons, especially on Mac OS X and Linux,
Windows is not reported to have similar issues.

Usually, the simplest way to fix this is to launch IDEA from the command line.
If that doesn't work then read on:

- Linux
--

You need to set ``` GOROOT ``` and ``` GOPATH ``` in ``` /etc/environment ```
to match the current values from your ``` .profile ```, ``` .bashrc ``` or ``` .zshrc ```
After that, you need to restart your system for the changes to take effect.


- Mac OS X
--

If you are launching the IDE the normal application launcher and you get the error message
about missing paths then you need to add ``` GOROOT ``` and ``` GOPATH ``` to your ``` ~/.profile ```
and then use: ```` launchctl setenv GOPATH $GOPATH ````.
You can view more [details here](https://github.com/mtoader/google-go-lang-idea-plugin/issues/318#issuecomment-31303939).


NOTE
===

Don't forget to keep the values in sync.
