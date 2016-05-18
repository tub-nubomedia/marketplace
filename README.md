# NUBOMEDIA Marketplace

This project is part of NUBOMEDIA project: [NUBOMEDIA][nubomedia.eu]

[![][NUBOMEDIA Logo]][NUBOMEDIA]

Copyright © 2016 [NUBOMEDIA]. Licensed under [LGPL v2.1 License].

The NUBOMEDIA Marketplace provides an easy way for managing and downloading NUBOMEDIA applications from a central point.
This allows users to share applications easily among the community that can be launched with a few clicks without making any adoptions.

The Marketplace provides an RESTful API for uploading, updating, downloading and deleting applications to/from the marketplace.

| Method        |URL                | Request Body                                              | Response Body                                                         |Meaning       										|
| ------------- |-------            |----------                                                 |----------                                                             |-------------										|
| POST  		|/api/v1/app        | json formatted application descriptor to upload           | uploaded application formatted in json                                | creates an new application for the marketplace    |
| GET           |/api/v1/app/<id>   | -                                                         | requested application with the given ID formatted in json             | returns the application with the given ID         |
| GET           |/api/v1/app        | -                                                         | list of all applications stored in the marketplace formatted in json  | lists all applications stored in the marketplace  |
| PUT           |/api/v1/app/<id>   | json formatted application descriptor used for updating   | returns updated application formatted in json                         | updates the application with the given ID         |
| DELETE        |/api/v1/app/<id>   | -                                                         |   -                                                                   | deletes the application with the given ID         |


## Application's json example

This section shows how an Application's json is structured and what the meaning of the parameters is.
Below it is shown how the json formatted application descriptor looks like:

```json
{
    "appName":"awesomeApplication",
    "description":"This application is just awesome",
    "provider":"FOKUS",
    "shared":true,
    "requirements":{
        "req1":"1",
        "req2":"2"
    },
    "projectName":"NUBOMEDIA",
    "gitURL":"https://github.com/nubomedia/nubomedia-magic-mirror.git",
    "ports":[
        {
            "port":8443,
            "targetPort":8443,
            "protocol":"TCP"
        },
        {
            "port":443,
            "targetPort":443,
            "protocol":"TCP"
        }
    ],
    "flavor":"MEDIUM",
    "replicasNumber":1,
    "secretName":null,
    "qualityOfService":null,
    "cloudRepository":false,
    "cdnConnector":false,
    "scaleInOut":3,
    "scale_out_threshold":150,
    "turnServerActivate":false,
    "turnServerUrl":null,
    "turnServerUsername":null,
    "turnServerPassword":null,
    "stunServerActivate":false,
    "stunServerIp":null,
    "stunServerPort":null
}

```

Each parameter has the following meaning:

| Parameter             |Meaning|
| -------------         |-------|
| appName               | Name of the application  |
| description           | Description of the application  |
| provider              | Provider of the application  |
| shared                | Shared between users. `true` if application should be publicly available, `false` if application should be private |
| requirements          | Map of requirements that must be met in order to launch the application  |
| projectName           | Name of the project  |
| gitURL                | Git URL of the repository where the executable application is located |
| ports                 | List of ports that must be provided at runtime |
| flavor                | Size of the KMSs: `SMALL`, `MEDIUM`, `LARGE`. Corresponds to OpenStack flavors |
| replicasNumber        | Number of OpenShift's container-based replicas |
| secretName            | Name of the private key to access the VMs |
| qualityOfService      | QoS level to use: `BRONZE`, `SILVER`, `GOLD`   |
| cloudRepository       | Indicates if a Cloud Repository is needed or not. `true` if yes, `false` if not. |
| cdnConnector          | Indicates if a CDN Connector is needed or not. `true` if yes, `false` if not. |
| scaleInOut            | Maximal number of VMs/KMSs to which can be scaled out |
| scale_out_threshold   | Scaling-out threshold that is used for scaling-out in case of crossing the defined threshold (metric is the consumed capacity in points) |
| turnServerActivate    | Indicates if a TURN server must be used. `true` if yes, `false` if not. |
| turnServerUrl         | URL of the TURN server  |
| turnServerUsername    | Username for authenticating towards the TURN server  |
| turnServerPassword    | Password for authenticating towards the TURN server  |
| stunServerActivate    | Indicates if a STUN server must be used. `true` if yes, `false` if not. |
| stunServerIp          | IP of the STUN server |
| stunServerPort        | Port of the STUN server  |

# What is NUBOMEDIA

This project is part of [NUBOMEDIA], which is an open source cloud Platform as a
Service (PaaS) which makes possible to integrate Real Time Communications (RTC)
and multimedia through advanced media processing capabilities. The aim of
NUBOMEDIA is to democratize multimedia technologies helping all developers to
include advanced multimedia capabilities into their Web and smartphone
applications in a simple, direct and fast manner. To accomplish that objective,
NUBOMEDIA provides a set of APIs that try to abstract all the low level details
of service deployment, management, and exploitation allowing applications to
transparently scale and adapt to the required load while preserving QoS
guarantees.

# Documentation

The [NUBOMEDIA] project provides detailed documentation including tutorials,
installation and [Development Guide].

# Source

Source code for other NUBOMEDIA projects can be found in the [GitHub NUBOMEDIA
Group].


# News

Follow us on Twitter @[NUBOMEDIA Twitter].

# Issue tracker

Issues and bug reports should be posted to [GitHub Issues].

# Licensing and distribution

Software associated to NUBOMEDIA is provided as open source under GNU Library or
"Lesser" General Public License, version 2.1 (LGPL-2.1). Please check the
specific terms and conditions linked to this open source license at
http://opensource.org/licenses/LGPL-2.1. Please note that software derived as a
result of modifying the source code of NUBOMEDIA software in order to fix a bug
or incorporate enhancements is considered a derivative work of the product.
Software that merely uses or aggregates (i.e. links to) an otherwise unmodified
version of existing software is not considered a derivative work.

# Contribution policy

You can contribute to the NUBOMEDIA community through bug-reports, bug-fixes,
new code or new documentation. For contributing to the NUBOMEDIA community,
drop a post to the [NUBOMEDIA Public Mailing List] providing full information
about your contribution and its value. In your contributions, you must comply
with the following guidelines

* You must specify the specific contents of your contribution either through a
  detailed bug description, through a pull-request or through a patch.
* You must specify the licensing restrictions of the code you contribute.
* For newly created code to be incorporated in the NUBOMEDIA code-base, you
  must accept NUBOMEDIA to own the code copyright, so that its open source
  nature is guaranteed.
* You must justify appropriately the need and value of your contribution. The
  NUBOMEDIA project has no obligations in relation to accepting contributions
  from third parties.
* The NUBOMEDIA project leaders have the right of asking for further
  explanations, tests or validations of any code contributed to the community
  before it being incorporated into the NUBOMEDIA code-base. You must be ready
  to addressing all these kind of concerns before having your code approved.

# Support

The NUBOMEDIA community provides support through the [NUBOMEDIA Public Mailing List].

[Development Guide]: http://nubomedia.readthedocs.org/
[GitHub Issues]: https://github.com/tub-nubomedia/marketplace/issues
[GitHub NUBOMEDIA Group]: https://github.com/nubomedia
[LGPL v2.1 License]: http://www.gnu.org/licenses/lgpl-2.1.html
[NUBOMEDIA Logo]: http://www.nubomedia.eu/sites/default/files/nubomedia_logo-small.png
[NUBOMEDIA Twitter]: https://twitter.com/nubomedia
[NUBOMEDIA Public Mailing list]: https://groups.google.com/forum/#!forum/nubomedia-dev
[NUBOMEDIA]: http://www.nubomedia.eu
