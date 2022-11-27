/** Utility scripts to help format and validate code */

class Util {
  /** verify if the fields are fill or not fill */
  validyProperty(property) {
    if (property !== null && property !== undefined && property !== "") {
      if (typeof property === "string" && property.trim() === "") return false;
      return true;
    }
    return false;
  }
}

export default Util;
