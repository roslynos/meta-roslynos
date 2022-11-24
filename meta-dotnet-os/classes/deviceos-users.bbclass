inherit extrausers

DOTNET_USER_ID ?= "1000"
DOTNET_USER_GROUP ?= "users"
DOTNET_USER_NAME ??= "vs"
DOTNET_USER_PASSWORD ??= "dotnet"
DOTNET_USER_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${DOTNET_USER_PASSWORD})"

ROOT_PASSWORD ??= "roslynos"
ROOT_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${ROOT_PASSWORD})"

DOTNET_USER_HOMEDIR ?= "/home/${DOTNET_USER_NAME}"

ROOTUSERMOD_COMMAND ?= "\
  --shell /bin/bash \
  root \
"

DOTNETUSERADD_COMMAND ?= "\
  --create-home \
  --groups ${DOTNET_USER_GROUP}\
  --uid ${DOTNET_USER_ID} \
  --home ${DOTNET_USER_HOMEDIR} \
  --shell /bin/bash \
  ${DOTNET_USER_NAME} \
"

EXTRA_USERS_PARAMS = "\
  groupadd ${DOTNET_USER_GROUP}; \
  useradd  ${DOTNETUSERADD_COMMAND}; \
  usermod -p '${DOTNET_USER_PASSWORD_ENCRYPTED}' ${DOTNET_USER_NAME}; \
  usermod ${ROOTUSERMOD_COMMAND} \
"

# EXTRA_USERS_PARAMS = "\
#   groupadd ${DOTNET_USER_GROUP}; \
#   useradd  ${DOTNETUSERADD_COMMAND}; \
#   usermod -p '${DOTNET_USER_PASSWORD_ENCRYPTED}' ${DOTNET_USER_NAME}; \
#   usermod ${ROOTUSERMOD_COMMAND} \
#   ${@bb.utils.contains('DISABLE_ROOT', '1', "usermod -L root;", "usermod -p '${ROOT_PASSWORD_ENCRYPTED}' root;", d)} \
# "